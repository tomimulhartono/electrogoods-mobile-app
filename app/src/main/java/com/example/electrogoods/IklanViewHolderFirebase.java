package com.example.electrogoods;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class IklanViewHolderFirebase extends RecyclerView.ViewHolder {

    public TextView tvHarga, tvJudul;

    public IklanViewHolderFirebase(View itemView){
        super(itemView);
        tvHarga = itemView.findViewById(R.id.hargatxt);
        tvJudul = itemView.findViewById(R.id.judultxt);
    }

    public void bindToIklanModel(IklanModel iklanModel, View.OnClickListener onClickListener){
        tvHarga.setText(iklanModel.price);
        tvJudul.setText(iklanModel.title);
    }
}
