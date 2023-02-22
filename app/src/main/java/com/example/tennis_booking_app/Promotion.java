package com.example.tennis_booking_app;

import static com.example.tennis_booking_app.R.drawable.discount;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.PhucHLH.SpecificCourtsActivity;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
#####################################################################
#	Nhân quả không nợ chúng ta thứ gì, cho nên xin đừng oán giận	#
#                                _oo0oo_							#
#                               088888880							#
#                               88" . "88							#
#                              (| __ __ |)							#
#                                0\ = /0							#
#                             ___/'---'\___							#
#                           .' \\|     |// '. 						#
#                          / \\|||  :  |||// \\						#
#                         /_ ||||| -:- |||||- \\					#
#                        |   | \\\  -  /// |   |					#
#                        | \_|  ''\---/''  |_/ |					#
#                        \  .-\__  '-'  __/-.  /					#
#                      ___'. .'  /--.--\  '. .'___					#
#                   ."" '<  '.___\_<|>_/___.' >'  "". 				#
#                  | | : '-  \'.;'\ _ /';.'/ - ' : | |				#
#                  \  \ '_.   \_ __\ /__ _/   .-' /  /				#
#           =========='-.____'.___ \_____/___.-'____.-'==========	#
#       	                    '=---='								#
#																	#
#            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
Đức Phật nơi đây phù hộ code con chạy không Bug. Nam mô a di đà Phật
*/

public class Promotion extends AppCompatActivity {
    RecyclerView rvPromo;
    Token TOKEN;
    String AUTHORIZATION;
    ArrayList<PagedCourtValue> arrPagedCourt;
    String noiDung;
    TextView txtType;
    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        rvPromo=(RecyclerView) findViewById(R.id.rvPromo);
        txtType = findViewById(R.id.txtType);

        loadingDialog = new LoadingDialog(Promotion.this);

        //get sharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sh.getString("TOKEN","");
        TOKEN = gson.fromJson(json,Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();
        loadPromoCourt();
    }

    private void loadPromoCourt() {
        PagedCourtRequest param_request = new PagedCourtRequest();
        param_request.setVendorId(11);
        param_request.setPageSize(10);
        param_request.setQueryString("");
        param_request.setCurrentPage(1);
        loadingDialog.startLoadingDialog();

        Call<PagedCourtResponse> pagedCourtResponseCall = ApiClient.getCourtService().getPagedPromoCourt(AUTHORIZATION,param_request.getVendorId(), param_request.getPageSize(), param_request.getQueryString(), param_request.getCurrentPage());
        System.out.println("request url \n" + pagedCourtResponseCall.request().url());

        pagedCourtResponseCall.enqueue(new Callback<PagedCourtResponse>() {
            @Override
            public void onResponse(Call<PagedCourtResponse> call, Response<PagedCourtResponse> response) {
                if(response.body() != null) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingDialog.dissmisDialog();
                        }
                    }, 1700);
                    arrPagedCourt= new ArrayList<>();
                    PagedCourtResponse pagedCourtResponse = response.body();
                    arrPagedCourt = (ArrayList) pagedCourtResponse.getValue();
                    PromoAdapter promoAdapter = new PromoAdapter(Promotion.this, arrPagedCourt);
                    rvPromo.setAdapter(promoAdapter);
                    rvPromo.setLayoutManager(new LinearLayoutManager(Promotion.this));

                }
            }

            @Override
            public void onFailure(Call<PagedCourtResponse> call, Throwable t) {

            }
        });
    }

}