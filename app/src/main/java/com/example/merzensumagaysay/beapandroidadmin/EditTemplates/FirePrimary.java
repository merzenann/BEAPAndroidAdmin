package com.example.merzensumagaysay.beapandroidadmin.EditTemplates;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.merzensumagaysay.beapandroidadmin.EditTemplates.FireTemplate;
import com.example.merzensumagaysay.beapandroidadmin.R;

import java.util.HashSet;

public class FirePrimary extends AppCompatActivity {

    int primaryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_primary);

        EditText editText = (EditText)findViewById(R.id.editText);

        Intent intent = getIntent();
        primaryId = intent.getIntExtra("primaryId", -1);
        if (primaryId != -1) {

            editText.setText(FireTemplate.command.get(primaryId));
        }else {
            FireTemplate.command.add("");
            FireTemplate.adapter.notifyDataSetChanged();
            primaryId = FireTemplate.command.size() - 1;
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FireTemplate.command.set(primaryId, String.valueOf(s));
                FireTemplate.adapter.notifyDataSetChanged();
                SharedPreferences sharedPreferences = getApplicationContext()
                        .getSharedPreferences("com.example.merzensumagaysay.beapandroidadmin", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<String>(FireTemplate.command);
                sharedPreferences.edit().putStringSet("command", set).apply();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
