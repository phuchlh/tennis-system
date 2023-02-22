package com.example.tennis_booking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class DanhGia extends AppCompatActivity {
    RecyclerView rvDanhGia;
    ArrayList<NdDanhGia> arrDanhGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_gia);
        arrDanhGia=new ArrayList<>();
        arrDanhGia.add(new NdDanhGia(R.drawable.avt2,R.drawable.dg3sao,"Sân mới sạch sẽ, dịch vụ tốt","truongnl"));
        arrDanhGia.add(new NdDanhGia(R.drawable.avt2,R.drawable.dg3sao,"Sân mới sạch sẽ, dịch vụ tốt","truongnl"));
        arrDanhGia.add(new NdDanhGia(R.drawable.avt2,R.drawable.dg3sao,"Sân mới sạch sẽ, dịch vụ tốt","truongnl"));
        arrDanhGia.add(new NdDanhGia(R.drawable.avt2,R.drawable.dg3sao,"Sân mới sạch sẽ, dịch vụ tốt","truongnl"));
        arrDanhGia.add(new NdDanhGia(R.drawable.avt2,R.drawable.dg3sao,"Sân mới sạch sẽ, dịch vụ tốt","truongnl"));

        rvDanhGia=(RecyclerView) findViewById(R.id.rvDanhGia);

        NdDanhGiaAdapter adapter=new NdDanhGiaAdapter(arrDanhGia);
        rvDanhGia.setAdapter(adapter);
        rvDanhGia.setLayoutManager(new LinearLayoutManager(this));
    }
}