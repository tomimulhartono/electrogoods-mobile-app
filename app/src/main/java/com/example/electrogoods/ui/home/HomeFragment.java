package com.example.electrogoods.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electrogoods.AdapterIklan;
import com.example.electrogoods.Categories;
import com.example.electrogoods.Filter;
import com.example.electrogoods.Iklan;
import com.example.electrogoods.IklanModel;
import com.example.electrogoods.Location;
import com.example.electrogoods.Notifications;
import com.example.electrogoods.R;
import com.example.electrogoods.ui.kategori.AdapterIklanKategori;
import com.example.electrogoods.ui.kategori.Gadget;
import com.example.electrogoods.ui.kategori.Household;
import com.example.electrogoods.ui.kategori.Office;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<IklanModel>listData;
    private RecyclerView rv;
    private AdapterIklan adapter;
    TextView title;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


//        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = root.findViewById(R.id.toolbar_home);
        EditText search = root.findViewById(R.id.editSearch);
        Button gadget = root.findViewById(R.id.gadget);
        Button office = root.findViewById(R.id.office);
        Button house = root.findViewById(R.id.household);
        ImageButton notif = root.findViewById(R.id.notifikasi);
        title = root.findViewById(R.id.toolbar_title);

        rv= root.findViewById(R.id.recyclerIklan);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
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
                    adapter=new AdapterIklan(getActivity(),listData);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(),"Data Gagal Dimuat", Toast.LENGTH_LONG).show();
                Log.e("MyListActivity", databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });





//        toolbar.setNavigationIcon(R.drawable.ic_location_white);
//        final TextView textView = root.findViewById(R.id.text_account);

        toolbar.findViewById(R.id.toolbar_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loc = new Intent(getActivity(), Location.class);
                startActivity(loc);
            }
        });

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent not = new Intent(getActivity(), Notifications.class);
                startActivity(not);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent loc = new Intent(getActivity(), Location.class);
//                startActivity(loc);
            }
        });

        gadget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gad = new Intent(getActivity(), Gadget.class);
                startActivity(gad);
            }
        });

        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ofis = new Intent(getActivity(), Office.class);
                startActivity(ofis);
            }
        });

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hos = new Intent(getActivity(), Household.class);
                startActivity(hos);
            }
        });
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}