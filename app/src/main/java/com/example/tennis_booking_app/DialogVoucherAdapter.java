package com.example.tennis_booking_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tennis_booking_app.Models.LoadImage;
import com.example.tennis_booking_app.Models.Voucher;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

public class DialogVoucherAdapter extends BaseAdapter {
    private Context context;
    List<Voucher> arrVoucher;
    private SharedPreferences sharedPreferences;

    public DialogVoucherAdapter(Context context, List<Voucher> arrVoucher, SharedPreferences sharedPreferences) {
        this.context = context;
        this.arrVoucher = arrVoucher;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public int getCount() {
        return arrVoucher.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.horizontal_promotion_view, null);

        TextView txtPromoName = convertView.findViewById(R.id.txtCourtNameHorizontalPromo);
        TextView txtDiscountPrice = convertView.findViewById(R.id.txtDiscount);
        ImageView imgPromo = convertView.findViewById(R.id.imgCourtPromoHorizontal);
        LinearLayout rcvPromoCourt = convertView.findViewById(R.id.rcvPromoCourt);

        Voucher voucher = arrVoucher.get(position);
        txtPromoName.setText(voucher.getName());
        txtDiscountPrice.setText(voucher.getDiscountPrice() + "");
        String imageURL = voucher.getImageUrl();
        LoadImage loadImage = new LoadImage(imgPromo);
        loadImage.execute(imageURL);

        return convertView;
    }
}
