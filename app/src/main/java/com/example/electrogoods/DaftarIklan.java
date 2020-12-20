package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DaftarIklan extends AppCompatActivity {

    Button follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_iklan);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        follow = findViewById(R.id.btnfollow);
        follow.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaftarIklan.this,DaftarIklan3.class);
                startActivity(intent);
            }
        })
    ;}

    /**
     * Inflates the menu, and adds items to the action bar if it is present.
     *
     * @param menu Menu to inflate.
     * @return Returns true if the menu inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles app bar item clicks.
     *
     * @param item Item clicked.
     * @return True if one of the defined items was clicked.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            case R.id.action_settings:
                displayToast(getString(R.string.action_settings_message));
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}
