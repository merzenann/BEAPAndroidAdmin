package com.example.merzensumagaysay.beapandroidadmin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class GuidelinesAdmin extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4, cb5;
    String check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines_admin);

        cb1 = (CheckBox)findViewById(R.id.MFCExit);

        cb2 = (CheckBox)findViewById(R.id.backgateExit);

        cb3 = (CheckBox)findViewById(R.id.mainExit);

        cb4 = (CheckBox)findViewById(R.id.mainGateExit);

        cb5 = (CheckBox)findViewById(R.id.LRTExit);


        Button mShowDialog = (Button) findViewById(R.id.sendToUsers);
        mShowDialog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {

                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked() && !cb5.isChecked())
                {
                    check = "noCheck";
                }

                if(cb1.isChecked())
                {
                    check = "exit1";
                }

                if(cb2.isChecked())
                {
                    check = "exit2";

                }

                if(cb3.isChecked())
                {
                    check = "exit3";

                }

                if(cb4.isChecked())
                {
                    check = "exit4";

                }

                if(cb2.isChecked())
                {
                    check = "exit5";

                }


                switch(check)
                {
                    case "noCheck":
                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(GuidelinesAdmin.this);
                        mBuilder.setTitle("NO EXITS SELECTED");
                        mBuilder.setMessage("Please choose safe exits");
                        mBuilder.setCancelable(false);
                        mBuilder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();
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
                        break;

                    case "exit1":
                        break;

                    case "exit2":
                        break;

                    case "exit3":
                        break;

                    case "exit4":
                        break;

                    case "exit5":
                        break;
                }

            }
        });
    }


}
