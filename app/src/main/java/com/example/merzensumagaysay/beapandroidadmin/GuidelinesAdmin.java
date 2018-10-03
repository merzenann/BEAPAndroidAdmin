package com.example.merzensumagaysay.beapandroidadmin;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuidelinesAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines_admin);

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
            }
        });
    }
}
