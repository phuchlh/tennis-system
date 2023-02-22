package com.example.tennis_booking_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tennis_booking_app.Models.LoadImage;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.http.Url;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> {

    //    private ArrayList<PromoClass> proList;
    Context context;
    private ArrayList<PagedCourtValue> arrPagedCourtValue;

    public PromoAdapter(Context context, ArrayList<PagedCourtValue> arrPagedCourtValue) {
        this.context = context;
        this.arrPagedCourtValue = arrPagedCourtValue;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_san_km, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            PagedCourtValue pagedCourtValue = arrPagedCourtValue.get(position);
            String imageUrl = pagedCourtValue.getImageUrl();
            System.out.println("image url + " + imageUrl);
            int ratingAVG = pagedCourtValue.getRatingAverage();
            if(ratingAVG == 0){
                holder.txtRating.setText(String.valueOf(5));
            }else{
                holder.txtRating.setText(String.valueOf(ratingAVG));
            }
            holder.txtTenSan.setText(pagedCourtValue.getName());
            holder.txtMaPromo.setText("123");
            holder.txtMaPromo1.setText("456");
            LoadImage loadImage = new LoadImage(holder.imgHinhSan);
            loadImage.execute(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        holder.txtPromo.setText(promo.getPromo());
//        holder.txtTenSan.setText(promo.getTenSan());
//        holder.txtDistant.setText(promo.getKhoangCach());
//        holder.txtMaPromo.setText(promo.getMaKM());
//        holder.txtMaPromo1.setText(promo.getMaKM1());
//        holder.imgHinhSan.setImageResource(promo.getHinh());
//        holder.imgStar.setImageResource(promo.getSao());
//        holder.imgThe.setImageResource(promo.getThe());
//        holder.imgThe1.setImageResource(promo.getThe1());
        holder.rcKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsPromotion.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrPagedCourtValue.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhSan, imgStar, imgThe, imgThe1;
        TextView txtPromo, txtTenSan, txtDistant, txtMaPromo, txtMaPromo1, txtRating;
        LinearLayout rcKM;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHinhSan = itemView.findViewById(R.id.imgHinhSan);
            imgStar = itemView.findViewById(R.id.imgStar);
            imgThe = itemView.findViewById(R.id.imgThePro);
            txtPromo = itemView.findViewById(R.id.txtPromo);
            txtTenSan = itemView.findViewById(R.id.txtTenSan);
            txtDistant = itemView.findViewById(R.id.txtDistant);
            txtMaPromo = itemView.findViewById(R.id.txtMaPromo);
            imgThe1 = itemView.findViewById(R.id.imgTheProo);
            txtMaPromo1 = itemView.findViewById(R.id.txtMaPromo1);
            rcKM = itemView.findViewById(R.id.rcKM);
            txtRating = itemView.findViewById(R.id.txtRatingPromo);
        }
    }
}
