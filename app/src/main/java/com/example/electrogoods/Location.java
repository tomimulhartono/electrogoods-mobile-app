package com.example.electrogoods;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.electrogoods.ui.home.HomeFragment;

import java.util.ArrayList;

public class Location extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_close);

        searchView = (SearchView) findViewById(R.id.cariLokasi);
        listView = (ListView) findViewById(R.id.daftarLokasi);

        list = new ArrayList<>();
        list.add("Aceh");
        list.add("Bali");
        list.add("Bangka Belitung");
        list.add("Banten");
        list.add("Bengkulu");
        list.add("Gorontalo");
        list.add("Jakarta");
        list.add("Jambi");
        list.add("Jawa Barat");
        list.add("Jawa Tengah");
        list.add("Jawa Timur");
        list.add("Kalimantan Barat");
        list.add("Kalimantan Selatan");
        list.add("Kalimantan Tengah");
        list.add("Kalimantan Timur");
        list.add("Kalimantan Utara");
        list.add("Kepulauan Riau");
        list.add("Lampung");
        list.add("Maluku");
        list.add("Maluku Utara");
        list.add("Nusa Tenggara Barat");
        list.add("Nusa Tenggara Timur");
        list.add("Papua");
        list.add("Papua Barat");
        list.add("Riau");
        list.add("Sulawesi Selatan");
        list.add("Sulawesi Tengah");
        list.add("Sulawesi Tenggara");
        list.add("Sulawesi Utara");
        list.add("Sumatera Barat");
        list.add("Sumatera Selatan");
        list.add("Sumatera Utara");
        list.add("Yogyakarta");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                    SharedPreferences.Editor editor = getSharedPreferences("LOKASI", MODE_PRIVATE).edit();
                    editor.putString("loc", query);
                    editor.apply();
                    finishAndRemoveTask();
                }else{
                    Toast.makeText(Location.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                searchView.setQuery((String) listView.getAdapter().getItem(i), false);
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
    public void currentLoc(View view) {
        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(Location.this);

        // Set the message show for the Alert time
        builder.setMessage("We were unable to access your location. Please, make sure your device location settings are enabled.");

        // Set Alert Title
        builder.setTitle("GEOLOCATION IS BLOCKED");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "SETTINGS",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
                                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
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
}