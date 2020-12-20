package com.example.electrogoods;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DaftarIklan3 extends AppCompatActivity {

    Button unfol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_iklan3);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        unfol = findViewById(R.id.btnunfollow);

        unfol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(DaftarIklan3.this);

                // Set Alert Title
                builder.setTitle("Do You Want To Unfollow?");

                // Set Cancelable false
                // for when the user clicks on the outside
                // the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name
                // OnClickListener method is use of
                // DialogInterface interface.

                builder
                        .setPositiveButton(
                                "UNFOLLOW",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {
                                        finishAndRemoveTask();
                                    }
                                });

                // Set the Negative button with No name
                // OnClickListener method is use
                // of DialogInterface interface.
                builder
                        .setNegativeButton(
                                "CANCEL",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {

                                        // If user click no
                                        // then dialog box is canceled.
                                        dialog.cancel();
                                    }
                                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
