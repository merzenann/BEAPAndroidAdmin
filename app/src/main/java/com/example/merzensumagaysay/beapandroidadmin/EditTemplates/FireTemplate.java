package com.example.merzensumagaysay.beapandroidadmin.EditTemplates;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.merzensumagaysay.beapandroidadmin.R;

import java.util.ArrayList;
import java.util.HashSet;


public class FireTemplate extends AppCompatActivity {

    ListView listView;
    public static ArrayList<String> command = new ArrayList<>();
    public static ArrayAdapter adapter;
    SharedPreferences sharedPreferences;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_command) {
            Intent intent = new Intent(this, FirePrimary.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_template);


        listView = (ListView) findViewById(R.id.listView);

        sharedPreferences = getApplicationContext()
                .getSharedPreferences("com.example.merzensumagaysay.beapandroidadmin", Context.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("command", null);

        if (set == null)
        {
            command.add("Add a new primary instruction");
        }
        else
        {
            command = new ArrayList(set);
        }


        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, command);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(FireTemplate.this, FirePrimary.class);
                intent.putExtra("primaryId", position);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final int itemToRemove = position;

                new AlertDialog.Builder(FireTemplate.this)
                        .setIcon(android.R.drawable.alert_dark_frame)
                        .setTitle("are you sure ?")
                        .setMessage("do you want to delete this note ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                command.remove(itemToRemove);
                                adapter.notifyDataSetChanged();
                                SharedPreferences sharedPreferences = getApplicationContext()
                                        .getSharedPreferences("com.example.ekene.mynotes", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet<String>(FireTemplate.command);
                                sharedPreferences.edit().putStringSet("notes", set).apply();
                            }

                        }).setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }
}

