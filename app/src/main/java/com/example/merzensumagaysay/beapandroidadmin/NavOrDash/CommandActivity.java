package com.example.merzensumagaysay.beapandroidadmin.NavOrDash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.merzensumagaysay.beapandroidadmin.EditTemplates.ActiveShooterTemplate;
import com.example.merzensumagaysay.beapandroidadmin.EditTemplates.BombThreatTemplate;
import com.example.merzensumagaysay.beapandroidadmin.EditTemplates.EarthquakeTemplate;
import com.example.merzensumagaysay.beapandroidadmin.EditTemplates.FireTemplate;
import com.example.merzensumagaysay.beapandroidadmin.EditTemplates.FloodTemplate;
import com.example.merzensumagaysay.beapandroidadmin.R;

public class CommandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);

        CardView earthquakeTemplate = findViewById(R.id.btnEartquake);
        earthquakeTemplate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CommandActivity.this, EarthquakeTemplate.class);
                startActivity(intent);
            }
        });

        CardView floodTemplate = findViewById(R.id.btnFlood);
        floodTemplate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CommandActivity.this, FloodTemplate.class);
                startActivity(intent);
            }
        });

        CardView bombThreat = findViewById(R.id.btnBombThreat);
        bombThreat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CommandActivity.this, BombThreatTemplate.class);
                startActivity(intent);
            }
        });

        CardView activeShooterTemplate = findViewById(R.id.btnActiveShooter);
        activeShooterTemplate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CommandActivity.this, ActiveShooterTemplate.class);
                startActivity(intent);
            }
        });

        CardView fireTemplate = findViewById(R.id.btnFire);
        fireTemplate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CommandActivity.this, FireTemplate.class);
                startActivity(intent);
            }
        });


    }
}
