package com.example.electrogoods.ui.sell;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.electrogoods.R;
import com.example.electrogoods.ui.kategori.GadgetSell;
import com.example.electrogoods.ui.kategori.HouseSell;
import com.example.electrogoods.ui.kategori.OfficeSell;

public class SellFragment extends Fragment {

    private SellViewModel sellViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        sellViewModel =
                ViewModelProviders.of(this).get(SellViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sell, container, false);
        ImageView gadget = root.findViewById(R.id.gadgetImageView);
        ImageView office = root.findViewById(R.id.officeImageView);
        ImageView household = root.findViewById(R.id.householdImageView);


        gadget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String set_category = "Gadget";
                Intent intent = new Intent(getActivity(), GadgetSell.class);
                intent.putExtra("Category", set_category);
                startActivity(intent);
            }
        });

        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String set_category = "Office";
                Intent intent = new Intent(getActivity(), OfficeSell.class);
                intent.putExtra("Category", set_category);
                startActivity(intent);
            }
        });

        household.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String set_category = "Household";
                Intent intent = new Intent(getActivity(), HouseSell.class);
                intent.putExtra("Category", set_category);
                startActivity(intent);
            }
        });

        return root;
    }
}