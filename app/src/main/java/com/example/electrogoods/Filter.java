package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.electrogoods.ui.kategori.DaftarIklanKategori;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Filter extends AppCompatActivity {

    SeekBar seekBar;
    ListView list;
    Button applie;
    EditText editMin, editMax;

    String[] maintitle = {
            "Categories", "Location",
    };

    Integer[] imgid = {
            R.drawable.arrow, R.drawable.arrow,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        Intent intent = getIntent();
        String cat = intent.getStringExtra("key");
        String loc = intent.getStringExtra("key2");
        String[] subtitle = {
                cat, loc,
        };
        MyListFilter adapter = new MyListFilter(this, maintitle, subtitle, imgid);
        list = (ListView) findViewById(R.id.list);
        applie = (Button) findViewById(R.id.button);
        list.setAdapter(adapter);

        applie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Filter.this, DaftarIklanKategori.class);
                startActivity(intent);
                finishAndRemoveTask();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    //code specific to first list item
                    //Toast.makeText(getApplicationContext(), "Place Your First Option Code", Toast.LENGTH_SHORT).show();
                    Intent kat = new Intent(Filter.this, Categories.class);
                    startActivity(kat);
                    finishAndRemoveTask();
                } else if (position == 1) {
                    //code specific to 2nd list item
                    /*Toast.makeText(getApplicationContext(), "Place Your Second Option Code", Toast.LENGTH_SHORT).show();*/
                    Intent loc = new Intent(Filter.this, Location.class);
                    startActivity(loc);
                }
            }
        });

//        seekBar=(SeekBar)findViewById(R.id.seekBar);
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress,
//                                          boolean fromUser) {
//                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
//            }
//        });

        RangeSeekBar seekBar = (RangeSeekBar)findViewById(R.id.rangeSeekbar);
        final EditText minEdit = (EditText)findViewById(R.id.editTextMin);
        final EditText maxEdit = (EditText)findViewById(R.id.editTextMax);
        final NumberFormat formatter = new DecimalFormat("#,###");
        seekBar.setRangeValues(100000, 10000000);

        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                String min = Integer.toString(minValue);
                String max = Integer.toString(maxValue);

                minEdit.setText("Rp."+min);
                maxEdit.setText("Rp."+max);
            }
        });
        seekBar.setNotifyWhileDragging(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finishAndRemoveTask();
        }

        return super.onOptionsItemSelected(item);
    }

}
