package com.example.electrogoods.ui.kategori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.electrogoods.MyListCategory;
import com.example.electrogoods.R;

public class Gadget extends AppCompatActivity {

    ListView list;

    String[] maintitle ={
            "Smartphone","Headphone",
            "Laptop",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadget);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        MyListGadget adapter=new MyListGadget(this, maintitle);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Intent intent = new Intent(Gadget.this, DaftarIklanKategori.class);
                    intent.putExtra("Pilihan", "Smartphone");
                    startActivity(intent);
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Intent intent = new Intent(Gadget.this, DaftarIklanKategori.class);
                    intent.putExtra("Pilihan", "Headphone");
                    startActivity(intent);
                }

                else if(position == 2) {
                    Intent intent = new Intent(Gadget.this, DaftarIklanKategori.class);
                    intent.putExtra("Pilihan", "Laptop");
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
