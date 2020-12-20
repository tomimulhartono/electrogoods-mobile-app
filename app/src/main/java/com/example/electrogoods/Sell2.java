package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sell2 extends AppCompatActivity {

    Button post_selling2;
    EditText add_merk, add_title, add_describe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell2);

        post_selling2 = findViewById(R.id.posting2);
        add_merk = findViewById(R.id.enter_merk);
        add_title = findViewById(R.id.enter_title);
        add_describe = findViewById(R.id.enter_describe);

        Intent get1 = getIntent();
        final String get_category = get1.getStringExtra("Category");
        final String get_pilihan = get1.getStringExtra("Pilihan");

        post_selling2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set_merk = add_merk.getText().toString();
                String set_title = add_title.getText().toString();
                String set_describe = add_describe.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Selling3.class);
                intent.putExtra("Category", get_category);
                intent.putExtra("Pilihan", get_pilihan);

                intent.putExtra("Merk", set_merk);
                intent.putExtra("Title", set_title);
                intent.putExtra("Describe", set_describe);
                startActivity(intent);
            }
        });
    }
}
