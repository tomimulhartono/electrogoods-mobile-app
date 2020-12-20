package com.example.electrogoods;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electrogoods.ui.kategori.AdapterIklanKategori;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Tab1FragmentAds extends Fragment {
    private final static String TAG = "Tab1FragmentAds";
    private List<IklanModel>listData;
    private RecyclerView rv;
    private AdapterIklanKategori adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment_myads,container,false);

        rv= view.findViewById(R.id.rvmyads);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        listData= new ArrayList<>();

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Iklan");
        nm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot snap : dataSnapshot.getChildren()){
                        IklanModel l = snap.getValue(IklanModel.class);
//                        l.setKey(snap.getKey());
                        listData.add(l);
                    }
                    adapter=new AdapterIklanKategori(getActivity(),listData);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(),"Data Gagal Dimuat", Toast.LENGTH_LONG).show();
                Log.e("MyListActivity", databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });

        return view;
    }
}
