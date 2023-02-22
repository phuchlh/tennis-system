package com.example.tennis_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class YardDetail extends AppCompatActivity {

    ListView lvSan;
    SanAdapter adapter;
    ArrayList<SanTennis> arrSan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yard_detail);

//        lvSan=(ListView) findViewById(R.id.lvSan);
//        arrSan=new ArrayList<>();
//        arrSan.add(new SanTennis("Sân 1A - Sân đất nện","36.57m x 18.29m","70.000 - 300.000 vnđ",R.drawable.san1a, "3 km", "4.3"));
//        arrSan.add(new SanTennis("Sân 2A - Sân PVC","36.57m x 18.29m","100.000 - 350.000 vnđ",R.drawable.san2a, "3 km", "4.5"));
//        arrSan.add(new SanTennis("Sân 2B - Sân cỏ","36.57m x 18.29m","150.00 - 400.000 vnđ",R.drawable.san2b, "3 km", "4.8"));
//
//        adapter=new SanAdapter(this,R.layout.list_san,arrSan);
//        lvSan.setAdapter(adapter);
//        lvSan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(YardDetail.this,Booking.class);
//                SanTennis sanTennis=arrSan.get(position);
//                intent.putExtra("sandetail",(Serializable) sanTennis);
//                startActivity(intent);
//            }
//        });


    }
}