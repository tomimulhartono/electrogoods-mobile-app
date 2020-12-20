package com.example.electrogoods.ui.kategori;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.electrogoods.DetailIklan;
import com.example.electrogoods.IklanModel;
import com.example.electrogoods.R;

import java.util.List;

public class AdapterIklanKategori extends RecyclerView.Adapter<AdapterIklanKategori.MyViewHolder> {

    private Context mContext;
    private List<IklanModel> mData;

    public AdapterIklanKategori(Context mContext, List<IklanModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_iklan,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tHarga.setText(mData.get(position).getPrice());
        holder.tJudul.setText(mData.get(position).getTitle());
        holder.tLokasi.setText(mData.get(position).getLocation());
        Glide.with(mContext)
                .load(mData.get(position).getImageurl()) // the uri you got from Firebase
                .into(holder.gIklan); //Your imageView variable
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailIklan.class);
                intent.putExtra("picture",mData.get(position).getImageurl());
                intent.putExtra("price",mData.get(position).getPrice());
                intent.putExtra("title",mData.get(position).getTitle());
                intent.putExtra("describe",mData.get(position).getDescribe());
                intent.putExtra("name",mData.get(position).getName());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tHarga, tJudul, tLokasi;
        ImageView gIklan;
        CardView cv;


        public MyViewHolder (View itemView){
            super(itemView);

            tHarga = itemView.findViewById(R.id.hargatxt);
            tJudul = itemView.findViewById(R.id.judultxt);
            tLokasi = itemView.findViewById(R.id.lokasitxt);
            gIklan = itemView.findViewById(R.id.gambariklan);
            cv = itemView.findViewById(R.id.idcard);

        }
    }
}
