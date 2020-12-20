package com.example.electrogoods.ui.kategori;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.electrogoods.Filter;
import com.example.electrogoods.IklanModel;
import com.example.electrogoods.R;

import java.util.ArrayList;
import java.util.List;

public class DaftarIklanKategori extends AppCompatActivity {

    private List<IklanModel>listData;
    private RecyclerView rv;
    private AdapterIklanKategori adapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_iklan_kategori);

        Intent intent = getIntent();
        final String kategori = intent.getStringExtra("Pilihan");

        Toolbar tobar = (Toolbar) findViewById(R.id.toolbar_kategori);
        Button fillter = (Button) findViewById(R.id.filter_btn);

        rv=(RecyclerView) findViewById(R.id.idrecycler);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        listData= new ArrayList<>();

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Iklan");
        nm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snap : dataSnapshot.getChildren()) {
                        IklanModel l = snap.getValue(IklanModel.class);
//                        l.setKey(snap.getKey());
                        listData.add(l);
                    }
                    adapter = new AdapterIklanKategori(DaftarIklanKategori.this, listData);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DaftarIklanKategori.this,"Data Gagal Dimuat", Toast.LENGTH_LONG).show();
                Log.e("MyListActivity", databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });

        tobar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black));
        tobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                finishAndRemoveTask();
            }
        });

        fillter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaftarIklanKategori.this, Filter.class);
                intent.putExtra("Pilihan", kategori);
                startActivity(intent);
            }
        });
    }
}
