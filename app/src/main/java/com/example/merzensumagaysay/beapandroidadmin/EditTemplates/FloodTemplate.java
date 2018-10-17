package com.example.merzensumagaysay.beapandroidadmin.EditTemplates;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.merzensumagaysay.beapandroidadmin.R;

import java.util.HashSet;

public class FloodTemplate extends AppCompatActivity {

    int floodprimaryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood_template);

        EditText editText = (EditText)findViewById(R.id.editText);

        Intent intent = getIntent();
        floodprimaryId = intent.getIntExtra("primaryId", -1);
        if (floodprimaryId != -1) {

            editText.setText(FloodPrimary.commandFlood.get(floodprimaryId));
        }else {
            FloodPrimary.commandFlood.add("");
            FloodPrimary.adapterFlood.notifyDataSetChanged();
            floodprimaryId = FloodPrimary.commandFlood.size() - 1;
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FloodPrimary.commandFlood.set(floodprimaryId, String.valueOf(s));
                FloodPrimary.adapterFlood.notifyDataSetChanged();
                SharedPreferences sharedPreferences = getApplicationContext()
                        .getSharedPreferences("com.example.merzensumagaysay.beapandroidadmin", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<String>(FloodPrimary.commandFlood);
                sharedPreferences.edit().putStringSet("commandFlood", set).apply();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
