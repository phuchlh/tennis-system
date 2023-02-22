package com.example.tennis_booking_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tennis_booking_app.Models.CourtSizeValue;
import com.example.tennis_booking_app.Models.LoadImage;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SanAdapter extends BaseAdapter {

    private Context context;
    private List<PagedCourtValue> sanTennisList;
    private SharedPreferences sharedPrefs;

    public SanAdapter(Context context, List<PagedCourtValue> sanTennisList, SharedPreferences sharedPrefs) {
        this.context = context;
        this.sanTennisList = sanTennisList;
        this.sharedPrefs = sharedPrefs;
    }

    @Override
    public int getCount() {
        return sanTennisList.size();
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
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.list_court_near,null);

        ImageView imgHinh=(ImageView) convertView.findViewById(R.id.imgHinh);
        TextView txtTen=(TextView) convertView.findViewById(R.id.txtTensan);
        TextView txtDientich=(TextView) convertView.findViewById(R.id.txtDientich);
        TextView txtTien=(TextView) convertView.findViewById(R.id.txtTien);
//        TextView txtKhoangCach =(TextView) convertView.findViewById(R.id.txtKhoangCach);
        TextView txtRating =(TextView) convertView.findViewById(R.id.txtRating);

        try {
            PagedCourtValue pagedCourtValue = sanTennisList.get(position);
            // get shared prefs
            sharedPrefs = context.getSharedPreferences("MySharedPref", 0);
            Gson gson = new Gson();
            String json = sharedPrefs.getString("LIST_COURT_SIZE", "[]");
            Type type = new TypeToken<ArrayList<CourtSizeValue>>(){}.getType();
            List<CourtSizeValue> listCourtSize = gson.fromJson(json, type);
            for (CourtSizeValue size: listCourtSize) {
                if(size.getId() == pagedCourtValue.getCourtSizeId()){
                    txtDientich.setText(size.getWidth() + "m " + "x" + size.getHeight() + "m ");
                }
            }
            txtTien.setText("100.000vnđ - 300.000vnđ");
            txtTen.setText(pagedCourtValue.getName());
            txtRating.setText(String.valueOf(pagedCourtValue.getRatingAverage()));
            String imageURL = pagedCourtValue.getImageUrl();
            LoadImage loadImage = new LoadImage(imgHinh);
            loadImage.execute(imageURL);
        }catch (Exception e){
            e.printStackTrace();
        }


//        PagedCourtResponse san= sanTennisList.get(position);
//
//        imgHinh.setImageResource(san.getHinh());
//        txtTen.setText(san.getTen());
//        txtDientich.setText(san.getDientich());
//        txtTien.setText(san.getTien());
//        txtKhoangCach.setText(san.getKhoangCach());
//        txtRating.setText(san.getRating());

        return convertView;
    }
}
