package com.example.merzensumagaysay.beapandroidadmin;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.CheckResult;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class GuidelinesAdmin extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4, cb5;

    String exit1, exit2, exit3, exit4, exit5;
    String comboResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines_admin);

        cb1 = (CheckBox)findViewById(R.id.MFCExit);

        Button mShowDialog = (Button) findViewById(R.id.sendToUsers);
        mShowDialog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(GuidelinesAdmin.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMessage(R.string.msgBP);
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Yes, I'm sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(cb1.isChecked())
                        {
                            exit1 = "MFCExit";
                            comboResult = exit1;
                        }
                        if(cb2.isChecked())
                        {
                            exit2 = "BGate";
                            comboResult = exit2;
                        }
                        if(cb3.isChecked())
                        {
                            exit3 = "Exit1";
                            comboResult = exit3;
                        }
                        if(cb4.isChecked())
                        {
                            exit4 = "Exit2";
                            comboResult = exit4;
                        }
                        if(cb5.isChecked())
                        {
                            exit5 = "LRTGate";
                            comboResult = exit5;
                        }
                        if(cb1.isChecked() && cb2.isChecked() && cb3.isChecked() && cb4.isChecked() && cb5.isChecked())
                        {
                            comboResult = "allExit";
                        }
                        if(cb1.isChecked() && cb2.isChecked())
                        {
                            comboResult = "MFCBGate";
                        }
                        if(cb1.isChecked() && cb3.isChecked())
                        {
                            comboResult = "MFCExit1";
                        }
                        if(cb1.isChecked() && cb4.isChecked())
                        {
                            comboResult = "MFCExit2";
                        }
                        if(cb1.isChecked() && cb5.isChecked())
                        {
                            comboResult = "MFCLRT";
                        }
                        if(cb2.isChecked() && cb3.isChecked())
                        {
                            comboResult = "BGExit1";
                        }
                        if(cb2.isChecked() && cb4.isChecked())
                        {
                            comboResult = "BGExit2";
                        }
                        if(cb2.isChecked() && cb5.isChecked())
                        {
                            comboResult = "BGLRT";
                        }
                        if(cb3.isChecked() && cb4.isChecked())
                        {
                            comboResult = "E1E2";
                        }
                        if(cb3.isChecked() && cb5.isChecked())
                        {
                            comboResult = "E1LRT";
                        }
                        if(cb4.isChecked() && cb5.isChecked())
                        {
                            comboResult = "E2LRT";
                        }

                        switch(comboResult)
                        {
                            case "MFCExit":
                                Toast.makeText(GuidelinesAdmin.this, "1", Toast.LENGTH_SHORT).show();
                                break;
                            case "BGate":
                                Toast.makeText(GuidelinesAdmin.this, "2", Toast.LENGTH_SHORT).show();
                                break;
                            case "Exit1":
                                Toast.makeText(GuidelinesAdmin.this, "3", Toast.LENGTH_SHORT).show();
                                break;
                            case "Exit2":
                                Toast.makeText(GuidelinesAdmin.this, "4", Toast.LENGTH_SHORT).show();
                                break;
                            case "LRTGate":
                                Toast.makeText(GuidelinesAdmin.this, "5", Toast.LENGTH_SHORT).show();
                                break;
                            case "allExit":
                                Toast.makeText(GuidelinesAdmin.this, "6", Toast.LENGTH_SHORT).show();
                                break;
                            case "MFCBGate":
                                Toast.makeText(GuidelinesAdmin.this, "7", Toast.LENGTH_SHORT).show();
                                break;
                            case "MFCExit1":
                                Toast.makeText(GuidelinesAdmin.this, "8", Toast.LENGTH_SHORT).show();
                                break;
                            case "MFCExit2":
                                Toast.makeText(GuidelinesAdmin.this, "9", Toast.LENGTH_SHORT).show();
                                break;
                            case "MFCLRT":
                                Toast.makeText(GuidelinesAdmin.this, "10", Toast.LENGTH_SHORT).show();
                                break;
                            case "BGExit1":
                                Toast.makeText(GuidelinesAdmin.this, "11", Toast.LENGTH_SHORT).show();
                                break;
                            case "BGExit2":
                                Toast.makeText(GuidelinesAdmin.this, "12", Toast.LENGTH_SHORT).show();
                                break;
                            case "BGLRT":
                                Toast.makeText(GuidelinesAdmin.this, "13", Toast.LENGTH_SHORT).show();
                                break;
                            case "E1E2":
                                Toast.makeText(GuidelinesAdmin.this, "14", Toast.LENGTH_SHORT).show();
                                break;
                            case "E1LRT":
                                Toast.makeText(GuidelinesAdmin.this, "15", Toast.LENGTH_SHORT).show();
                                break;
                            case "E2LRT":
                                Toast.makeText(GuidelinesAdmin.this, "16", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        Intent intent = new Intent(GuidelinesAdmin.this,BlueprintSafestExit.class);
                        startActivity(intent);
                    }
                });
                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();
            }
        });

    }

}
