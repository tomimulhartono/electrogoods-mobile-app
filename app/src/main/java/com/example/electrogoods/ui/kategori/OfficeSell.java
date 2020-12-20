package com.example.electrogoods.ui.kategori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.electrogoods.R;
import com.example.electrogoods.Sell2;

public class OfficeSell extends AppCompatActivity {

    ListView list;

    String[] maintitle ={
            "Printer","Computer Dekstop",
            "Storage",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        Intent get = getIntent();
        final String get_category = get.getStringExtra("Category");

        MyListOffice adapter=new MyListOffice(this, maintitle);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Intent intent = new Intent(OfficeSell.this, Sell2.class);
                    intent.putExtra("Category", get_category);
                    intent.putExtra("Pilihan", "Printer");
                    startActivity(intent);
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Intent intent = new Intent(OfficeSell.this, Sell2.class);
                    intent.putExtra("Category", get_category);
                    intent.putExtra("Pilihan", "Computer Dekstop");
                    startActivity(intent);
                }

                else if(position == 2) {
                    Intent intent = new Intent(OfficeSell.this, Sell2.class);
                    intent.putExtra("Category", get_category);
                    intent.putExtra("Pilihan", "Storage");
                    startActivity(intent);
                }

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