package com.example.electrogoods.ui.kategori;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.electrogoods.R;

public class MyListGadget extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;

    public MyListGadget(Activity context, String[] maintitle) {
        super(context, R.layout.mylistgadget, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylistgadget, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);

        titleText.setText(maintitle[position]);

        return rowView;

    };
}
