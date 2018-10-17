package com.example.merzensumagaysay.beapandroidadmin.EditTemplates;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.merzensumagaysay.beapandroidadmin.R;

import java.util.ArrayList;
import java.util.HashSet;

public class FloodPrimary extends AppCompatActivity {

    ListView floodList;
    public static ArrayList<String> commandFlood = new ArrayList<>();
    public static ArrayAdapter adapterFlood;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood_primary);


        floodList = (ListView) findViewById(R.id.listView);

        sharedPreferences = getApplicationContext()
                .getSharedPreferences("com.example.merzensumagaysay.beapandroidadmin", Context.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("commandFlood", null);

        if (set == null)
        {
            commandFlood.add("Add a new primary instruction");
        }
        else
        {
            commandFlood = new ArrayList(set);
        }


        adapterFlood = new ArrayAdapter(this, android.R.layout.simple_list_item_1, commandFlood);

        floodList.setAdapter(adapterFlood);
        floodList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(FloodPrimary.this, FloodTemplate.class);
                intent.putExtra("primaryId", position);
                startActivity(intent);
            }
        });

        floodList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final int itemToRemove = position;

                new AlertDialog.Builder(FloodPrimary.this)
                        .setIcon(android.R.drawable.alert_dark_frame)
                        .setTitle("are you sure ?")
                        .setMessage("do you want to delete this note ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                commandFlood.remove(itemToRemove);
                                adapterFlood.notifyDataSetChanged();
                                SharedPreferences sharedPreferences = getApplicationContext()
                                        .getSharedPreferences("com.example.merzensumagaysay.beapandroidadmin", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet<String>(FloodPrimary.commandFlood);
                                sharedPreferences.edit().putStringSet("commandFlood", set).apply();
                            }

                        }).setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }
}


