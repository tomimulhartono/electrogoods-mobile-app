package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;

public class Selling7 extends AppCompatActivity {

    Button post_selling7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling7);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Iklan");

        post_selling7 = findViewById(R.id.preview_ad);

        Intent get6 = getIntent();
        final String get_category = get6.getStringExtra("Category");
        final String get_pilihan = get6.getStringExtra("Pilihan");
        final String get_merk = get6.getStringExtra("Merk");
        final String get_title = get6.getStringExtra("Title");
        final String get_describe = get6.getStringExtra("Describe");
        final String get_picture = get6.getStringExtra("Picture");
        final String get_price = get6.getStringExtra("Price");
        final String get_location = get6.getStringExtra("Location");
//        final Bitmap bitmap_photo = get6.getParcelableExtra("Photo");
        final String get_name = get6.getStringExtra("Name");
        final String get_phone = get6.getStringExtra("Phone");

        post_selling7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Explore.class);
                String id = myRef.push().getKey();

                IklanModel iklan = new IklanModel(get_category, get_pilihan, get_merk, get_title, get_describe, get_price, get_name, get_phone, get_location, get_picture);
                myRef.child(id).setValue(iklan);
                Toast.makeText(Selling7.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
