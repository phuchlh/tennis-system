package com.example.tennis_booking_app.PhucHLH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tennis_booking_app.DetailsPromotion;
import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.PromoAdapter;
import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.SanAdapter;
import com.example.tennis_booking_app.SanTennis;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecificCourtsActivity extends AppCompatActivity {

    TextView txtType;
    ListView lvSpecific;
    List<PagedCourtValue> arrSanCo;
    Adapter sanAdapter;
    String noiDung = null;
    Token TOKEN;
    String AUTHORIZATION;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_courts);
        txtType = findViewById(R.id.txtType);
        lvSpecific = (ListView) findViewById(R.id.lvSpecificCourt);

        //get sharedPreference
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sharedPreferences.getString("TOKEN","");
        TOKEN = gson.fromJson(json,Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();

        AnhXa();

//        lvSpecific.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(SpecificCourtsActivity.this, DetailsPromotion.class);
//                SanTennis sanTennis = arrSan.get(position);
//                intent.putExtra("sandetail", (Serializable) sanTennis);
//                startActivity(intent);
//            }
//        });
    }

    private void AnhXa() {
        Intent intent = getIntent();
        noiDung = intent.getStringExtra("sandetail");
        if (noiDung.equals("Clay")) {
            txtType.setText("Sân đất nện");
            loadCourtByType(2);
        } else if (noiDung.equals("Hard")) {
            txtType.setText("Sân cứng");
            loadCourtByType(3);
        } else if (noiDung.equals("Grass")) {
            txtType.setText("Sân cỏ");
            loadCourtByType(1);
        }
        else {
            // search, later
        }
    }
    private void loadCourtByType(int courtType){
        PagedCourtRequest paramsRequest = new PagedCourtRequest();
        paramsRequest.setPageSize(7);
        paramsRequest.setCurrentPage(1);
        paramsRequest.setTypeId(courtType);
                                                                                        // PageSize=7&CurrentPage=1&typeId=1
        Call<PagedCourtResponse> pagedCourtResponseCall = ApiClient.getCourtService().getPagedListCourtByType(AUTHORIZATION, paramsRequest.getPageSize(), paramsRequest.getCurrentPage(), paramsRequest.getTypeId());
        pagedCourtResponseCall.enqueue(new Callback<PagedCourtResponse>() {
            @Override
            public void onResponse(Call<PagedCourtResponse> call, Response<PagedCourtResponse> response) {
                if(response.body() !=null){
                    arrSanCo = (List) response.body().getValue();
                    sanAdapter = new SanAdapter(SpecificCourtsActivity.this, arrSanCo, sharedPreferences);
                    lvSpecific.setAdapter((ListAdapter) sanAdapter);
                }
            }

            @Override
            public void onFailure(Call<PagedCourtResponse> call, Throwable t) {

            }
        });
    }
}
