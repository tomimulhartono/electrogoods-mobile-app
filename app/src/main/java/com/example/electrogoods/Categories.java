package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Categories extends AppCompatActivity {
    ListView list;

    String[] maintitle ={
            "Gadget","Office",
            "Household",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        MyListCategory adapter=new MyListCategory(this, maintitle);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    String value="Gadget";
                    Intent i = new Intent(Categories.this, Filter.class);
                    i.putExtra("key",value);
                    startActivity(i);
                    finishAndRemoveTask();
                }

                else if(position == 1) {
                    String value="Office";
                    Intent i = new Intent(Categories.this, Filter.class);
                    i.putExtra("key",value);
                    startActivity(i);
                    finishAndRemoveTask();
                }

                else if(position == 2) {
                    String value="Household";
                    Intent i = new Intent(Categories.this, Filter.class);
                    i.putExtra("key",value);
                    startActivity(i);
                    finishAndRemoveTask();
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
