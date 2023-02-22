package com.example.tennis_booking_app.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tennis_booking_app.DetailsPromotion;
import com.example.tennis_booking_app.Models.CourtSizeValue;
import com.example.tennis_booking_app.Models.LoadImage;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.ViewModels.PromotingCourtHome.PromotingHomeResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CourtFavouriteAdapter extends RecyclerView.Adapter<CourtFavouriteAdapter.MyViewHolder> {
//    private ArrayList<PagedCourtValue> arrPageCourtValue;
    private List<PromotingHomeResponse> arrPageCourtValue;
    Context context;
    private SharedPreferences sharedPrefs;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCourt;
        TextView txtCourtName, txtAddress, txtSize, txtPrice;
        LinearLayout courtContainer;
        LinearLayout rvFavCourt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCourt = itemView.findViewById(R.id.imgCourtFav);
            txtCourtName = itemView.findViewById(R.id.txtCourtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtSize = itemView.findViewById(R.id.txtSize);
            txtPrice = itemView.findViewById(R.id.txtCourtPrice);
            rvFavCourt = itemView.findViewById(R.id.courtContainer);
            courtContainer = itemView.findViewById(R.id.courtContainer);
        }
    }

    public CourtFavouriteAdapter(Context context, List<PromotingHomeResponse> arrPageCourtValue, SharedPreferences sharedPrefs) {
        this.arrPageCourtValue = arrPageCourtValue;
        this.context = context;
        this.sharedPrefs = sharedPrefs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_court_favourite, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            // array trả về từ Home
//            PagedCourtValue pagedCourtValue = arrPageCourtValue.get(position);
            PromotingHomeResponse pagedCourtValue = arrPageCourtValue.get(position);

            sharedPrefs = context.getSharedPreferences("MySharedPref", 0);
            Gson gson = new Gson();
            String json = sharedPrefs.getString("LIST_COURT_SIZE", "[]");
            Type type = new TypeToken<ArrayList<CourtSizeValue>>() {}.getType();
            List<CourtSizeValue> listCourtSize = gson.fromJson(json,type);


            for (CourtSizeValue size : listCourtSize) {
                if(size.getId() == pagedCourtValue.getCourtSizeId()) {
                    holder.txtSize.setText(size.getWidth() + "m " + "x" + size.getHeight() + "m ");
                }
            }
            holder.txtCourtName.setText(pagedCourtValue.getName());
            holder.txtAddress.setText("AAA");
            holder.txtPrice.setText("123123123");
            // set image

            holder.imgCourt.setMaxWidth(200);
            holder.imgCourt.setMaxWidth(200);
            String imageUrl = pagedCourtValue.getImageUrl();
            LoadImage loadImage = new LoadImage(holder.imgCourt);
            loadImage.execute(imageUrl);

            holder.rvFavCourt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailsPromotion.class);
                    intent.putExtra("vendorID", pagedCourtValue.getVendorId());
                    context.startActivity(intent);
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }

//        holder.imgCourt.setImageResource(court_fav.getImgCourt());
//        holder.txtCourtName.setText(court_fav.getName());
//        holder.txtAddress.setText(court_fav.getAddress());
//        holder.txtSize.setText(court_fav.getWidth() + "m" + " x " + court_fav.getHeight() + "m");
//        holder.txtPrice.setText(court_fav.getPrice());

//        holder.rvFavCourt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailsPromotion.class);
//                intent.putExtra("sandetail1", (Serializable) court_fav);
//                context.startActivity(intent);
//            }
//        });
//
//        holder.rvSan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context, YardDetail.class);
//                intent.putExtra("sandetail", (Serializable) sanKM);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return arrPageCourtValue.size();
    }
}
