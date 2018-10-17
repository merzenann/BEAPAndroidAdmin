package com.example.merzensumagaysay.beapandroidadmin.NavOrDash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.merzensumagaysay.beapandroidadmin.GuidelinesAdmin;
import com.example.merzensumagaysay.beapandroidadmin.R;

public class AlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        Button sendAlert = (Button) findViewById(R.id.sendAlert);
        sendAlert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GuidelinesAdmin.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    }
