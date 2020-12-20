package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailIklan extends AppCompatActivity {

    ImageView photo_product, photo_profile;
    TextView price_product, title_product, location_product, describe_product, name_user;
    TextView see;
    Button chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_iklan);

//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_close);

        photo_product = findViewById(R.id.thumbnail);
        price_product = findViewById(R.id.harga);
        title_product = findViewById(R.id.judul);
        location_product = findViewById(R.id.lokasi);
        describe_product = findViewById(R.id.deskripsi);
        photo_profile = findViewById(R.id.imageView);
        name_user = findViewById(R.id.textView17);

        Intent get7 = getIntent();
        final String get_title = get7.getStringExtra("title");
        final String get_describe = get7.getStringExtra("describe");
        final String get_picture = get7.getStringExtra("picture");
        final String get_price = get7.getStringExtra("price");
        final String get_location = get7.getStringExtra("location");
        final Bitmap bitmap_photo = get7.getParcelableExtra("photo");
        final String get_name = get7.getStringExtra("name");

        Glide.with(this)
                .load(get_picture) // the uri you got from Firebase
                .into(photo_product); //Your imageView variable
        price_product.setText(get_price);
        title_product.setText(get_title);
        location_product.setText(get_location);
        describe_product.setText(get_describe);
        photo_profile.setImageBitmap(bitmap_photo);
        name_user.setText(get_name);

        see = findViewById(R.id.textView19);
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailIklan.this,DaftarIklan.class);
                startActivity(intent);
            }
        });

        chat = findViewById(R.id.button);
        chat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(DetailIklan.this, Chat.class);
                startActivity(intent);
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
