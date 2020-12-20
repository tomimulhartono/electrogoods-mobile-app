package com.example.electrogoods;

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

import java.util.List;

public class AdapterIklan extends RecyclerView.Adapter<AdapterIklan.MyViewHolder> {

    private Context mContext;
    private List<IklanModel> mData;

    public AdapterIklan(Context mContext, List<IklanModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tHarga.setText(mData.get(position).getPrice());
        holder.tJudul.setText(mData.get(position).getTitle());
        holder.tDesc.setText(mData.get(position).getDescribe());
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

        TextView tHarga, tJudul, tLokasi, tDesc;
        ImageView gIklan;
        CardView cv;


        public MyViewHolder (View itemView){
            super(itemView);

            tHarga = (TextView) itemView.findViewById(R.id.id_textHarga);
            tJudul = (TextView) itemView.findViewById(R.id.id_textJudul);
            tDesc = (TextView) itemView.findViewById(R.id.id_textDeskripsi);
            tLokasi = (TextView) itemView.findViewById(R.id.id_textLokasi);
            gIklan = (ImageView) itemView.findViewById(R.id.id_gambarIklan);
            cv = (CardView) itemView.findViewById(R.id.id_cardView);

        }
    }
}
