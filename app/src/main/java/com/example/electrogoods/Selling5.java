package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;


public class Selling5 extends AppCompatActivity {

    Button post_selling5;
    ListView list;

    String[] maintitle = {
            "Location",
    };

    Integer[] imgid = {
            R.drawable.arrow,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling5);

        SharedPreferences preferences = getSharedPreferences("LOKASI", MODE_PRIVATE);
        String loc = preferences.getString("loc", "Lokasi");
        String[] subtitle = {
                loc,
        };

        MyListFilter adapter = new MyListFilter(this, maintitle, subtitle, imgid);
        list = (ListView) findViewById(R.id.listLoc);
        post_selling5 = findViewById(R.id.posting5);
        list.setAdapter(adapter);

        Intent get4 = getIntent();
        final String get_category = get4.getStringExtra("Category");
        final String get_pilihan = get4.getStringExtra("Pilihan");
        final String get_merk = get4.getStringExtra("Merk");
        final String get_title = get4.getStringExtra("Title");
        final String get_describe = get4.getStringExtra("Describe");
        final String get_picture = get4.getStringExtra("Picture");
        final String get_price = get4.getStringExtra("Price");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent loc = new Intent(Selling5.this, Location.class);
                    startActivity(loc);
                    onPause();
                }
            }
        });

        post_selling5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("LOKASI", MODE_PRIVATE);
                String set_location = preferences.getString("loc", "Lokasi");

                Intent intent = new Intent(getApplicationContext(), Selling6.class);
                intent.putExtra("Category", get_category);
                intent.putExtra("Pilihan", get_pilihan);
                intent.putExtra("Merk", get_merk);
                intent.putExtra("Title", get_title);
                intent.putExtra("Describe", get_describe);
                intent.putExtra("Picture", get_picture);
                intent.putExtra("Price", get_price);

                intent.putExtra("Location", set_location);
                startActivity(intent);
            }
        });
    }
}