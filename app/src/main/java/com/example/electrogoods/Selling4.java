package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Selling4 extends AppCompatActivity {

    EditText input_price;
    Button post_selling4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling4);

        input_price = findViewById(R.id.enter_price);
        post_selling4 = findViewById(R.id.posting4);

        Intent get3 = getIntent();
        final String get_category = get3.getStringExtra("Category");
        final String get_pilihan = get3.getStringExtra("Pilihan");
        final String get_merk = get3.getStringExtra("Merk");
        final String get_title = get3.getStringExtra("Title");
        final String get_describe = get3.getStringExtra("Describe");
        final String get_picture = get3.getStringExtra("Picture");

        post_selling4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set_price = input_price.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Selling5.class);
                intent.putExtra("Category", get_category);
                intent.putExtra("Pilihan", get_pilihan);
                intent.putExtra("Merk", get_merk);
                intent.putExtra("Title", get_title);
                intent.putExtra("Describe", get_describe);
                intent.putExtra("Picture", get_picture);

                intent.putExtra("Price", set_price);
                startActivity(intent);
            }
        });
    }
}
