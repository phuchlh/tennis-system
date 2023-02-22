package com.example.tennis_booking_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NdDanhGiaAdapter extends RecyclerView.Adapter<NdDanhGiaAdapter.ViewHolder> {

    private ArrayList<NdDanhGia> listDanhGia;

    public NdDanhGiaAdapter(ArrayList<NdDanhGia> listDanhGia) {
        this.listDanhGia = listDanhGia;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);

        View view=inflater.inflate(R.layout.list_danh_gia,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NdDanhGia nd=listDanhGia.get(position);

        holder.imgUserDG.setImageResource(nd.getUser());
        holder.imgSao.setImageResource(nd.getSao());
        holder.txtDanhGia.setText(nd.getNoiDung());
        holder.txtTenDG.setText(nd.getTenUser());
    }

    @Override
    public int getItemCount() {
        return listDanhGia.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUserDG,imgSao;
        TextView txtDanhGia,txtTenDG;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUserDG=itemView.findViewById(R.id.imgUserDG);
            imgSao=itemView.findViewById(R.id.imgSao);
            txtDanhGia=itemView.findViewById(R.id.txtDanhGia);
            txtTenDG=itemView.findViewById(R.id.txtTenDG);

        }
    }
}
