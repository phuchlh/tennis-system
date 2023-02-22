package com.example.tennis_booking_app.activity.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.CourtSizeValue;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.Promotion;
import com.example.tennis_booking_app.ViewModels.CourtSize.CourtSizeRequest;
import com.example.tennis_booking_app.ViewModels.CourtSize.CourtSizeResponse;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.example.tennis_booking_app.ViewModels.PromotingCourtHome.PromotingHomeRequest;
import com.example.tennis_booking_app.ViewModels.PromotingCourtHome.PromotingHomeResponse;
import com.example.tennis_booking_app.ViewModels.Vendor.VendorRequest;
import com.example.tennis_booking_app.ViewModels.Vendor.VendorResponse;
import com.example.tennis_booking_app.adapter.home.CourtFavouriteAdapter;
import com.example.tennis_booking_app.DangXuat;
import com.example.tennis_booking_app.adapter.home.HorizontalAdapter;
import com.example.tennis_booking_app.LichSu;
import com.example.tennis_booking_app.R;
import com.example.tennis_booking_app.PhucHLH.SearchPageActivity;
import com.example.tennis_booking_app.PhucHLH.SpecificCourtsActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ImageView imgSearchBar, imgHard, imgClay, imgGrass, imgUser, imgHistory, imgNearMe, imgPromo;
    HorizontalAdapter horizontalAdapter;
    RecyclerView viewPromo, viewFavCourt;
    TextView txtWelcome;
    List<VendorResponse> arrPromoHome;
    ArrayList<PagedCourtValue> arrFavHome;
    List<PromotingHomeResponse> arrPromotingHome;
    List<PagedCourtResponse> arrAPIPaged;
    List<PromotingHomeResponse> arrPromoResponse;
    Token TOKEN;
    String AUTHORIZATION;
    SharedPreferences sharedPreferences;
    ArrayList<CourtSizeValue> arrSizeResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imgSearchBar = (ImageView) findViewById(R.id.imgSearchBar);
        imgClay = (ImageView) findViewById(R.id.imgClay);
        imgHard = (ImageView) findViewById(R.id.imgHard);
        imgGrass = (ImageView) findViewById(R.id.imgGrass);
        imgUser = (ImageView) findViewById(R.id.imgUser);
        imgHistory = (ImageView) findViewById(R.id.imgHistory);
        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        imgPromo = (ImageView) findViewById(R.id.imgPromo);
        arrAPIPaged = new ArrayList<>();

        viewPromo = (RecyclerView) findViewById(R.id.viewPromo);
        viewFavCourt = (RecyclerView) findViewById(R.id.viewFavCourt);

//        horizontalAdapter = new HorizontalAdapter(this, arrSanPromo);
//        courtFavouriteAdapter = new CourtFavouriteAdapter(this, arrPromoHome);
//        LinearLayoutManager mLayoutFavourite = new LinearLayoutManager(getApplicationContext());
//        mLayoutFavourite.setOrientation(LinearLayoutManager.HORIZONTAL);
//        viewFavCourt.setAdapter(courtFavouriteAdapter);
//        arrPageCourtValue = new ArrayList<>();

        arrSizeResponse = new ArrayList<>();

        //get sharedPreference
        sharedPreferences = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sharedPreferences.getString("TOKEN", "");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();

        System.out.println("user id" + TOKEN.getUserId());

        setWelcome();

//        initData();

        callSize();

        loadPromo();
//        loadHighRating();
        getHighRating();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#AFF8A3"));
        }

        imgPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Promotion.class);
                startActivity(intent);
            }
        });

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DangXuat.class);
                startActivity(intent);
            }
        });

        imgHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LichSu.class);
                startActivity(intent);
            }
        });

        imgSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SearchPageActivity.class);
                startActivity(intent);
            }
        });

        imgHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Hard");
                startActivity(intent);
            }
        });

        imgClay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Clay");
                startActivity(intent);
            }
        });

        imgGrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpecificCourtsActivity.class);
                intent.putExtra("sandetail", "Grass");
                startActivity(intent);
            }
        });

    }

    private void setWelcome() {
        txtWelcome.setText("Xin chào " + TOKEN.getFullName() + "!");
    }

//    private void initData() {
//        arrSanPromo.add(new SanKM("Sân Thủ Đức", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "4.9", "2.3km"));
//        arrSanPromo.add(new SanKM("Sân Kim Sa", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "4.1", "10.4km"));
//        arrSanPromo.add(new SanKM("Sân Lam Sơn", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "4.2", "20km"));
//        arrSanPromo.add(new SanKM("Sân Hoàng Sa", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "4.9", "12km"));
//        arrSanPromo.add(new SanKM("Sân Trường Sa", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "5", "12.8km"));
//        arrSanPromo.add(new SanKM("Sân Quận 7", "Ưu Đãi Đến 50k", "", "Khuyễn Mãi", R.drawable.tennis_grass, "5", "9.6km"));
//        horizontalAdapter.notifyDataSetChanged();
//    }

    private void loadPromo(){
        VendorRequest vendorRequest = new VendorRequest();
        vendorRequest.setPageSize(11);

        Call<List<VendorResponse>> vendorResponseCall = ApiClient.getVendorService().getPromotingVendorHome(AUTHORIZATION, vendorRequest.getPageSize());
        System.out.println("request url \n" + vendorResponseCall.request().url());
        vendorResponseCall.enqueue(new Callback<List<VendorResponse>>() {
            @Override
            public void onResponse(Call<List<VendorResponse>> call, Response<List<VendorResponse>> response) {
                if(response.body() != null){
                    // set horizontal view
                    LinearLayoutManager mLayoutPromoting = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                    viewPromo.setLayoutManager(mLayoutPromoting);
                    viewPromo.setItemAnimator(new DefaultItemAnimator());
                    // handle api data
                    arrPromoHome = (List) response.body();
                    System.out.println("arr promo " + arrPromoHome);
                    HorizontalAdapter courtPromotingAdapter = new HorizontalAdapter(HomeActivity.this, (ArrayList<VendorResponse>) arrPromoHome, sharedPreferences);
                    // set Adapter
                    viewPromo.setLayoutManager(mLayoutPromoting);
                    viewPromo.setAdapter(courtPromotingAdapter);
                    courtPromotingAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<VendorResponse>> call, Throwable t) {

            }
        });
    }

/*
    private void loadHighRating() {
        PagedCourtRequest paramsRequest = new PagedCourtRequest();
        paramsRequest.setCurrentPage(1);
        paramsRequest.setVendorId(520);
        paramsRequest.setQueryString("");
        paramsRequest.setPageSize(7);

        Call<PagedCourtResponse> pagedCourtResponseCall = ApiClient.getCourtService().getPagedListHighRating(AUTHORIZATION, paramsRequest.getVendorId(), paramsRequest.getPageSize(), paramsRequest.getQueryString(), paramsRequest.getCurrentPage());
        System.out.println("request home url \n" + pagedCourtResponseCall.request().url());
            pagedCourtResponseCall.enqueue(new Callback<PagedCourtResponse>() {
                @Override
                public void onResponse(Call<PagedCourtResponse> call, Response<PagedCourtResponse> response) {
                    if (response.code() == 200) {
                        // set horizontal view
                        LinearLayoutManager mLayoutFavourite = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                        viewFavCourt.setLayoutManager(mLayoutFavourite);
                        viewFavCourt.setItemAnimator(new DefaultItemAnimator());
                        // handle api data
                        arrFavHome = new ArrayList<>();
                        PagedCourtResponse pagedCourtResponse = response.body();
                        arrFavHome = (ArrayList) pagedCourtResponse.getValue();
                        System.out.println("arr promo home " + arrFavHome);
                        CourtFavouriteAdapter courtFavAdapter = new CourtFavouriteAdapter(HomeActivity.this, arrFavHome, sharedPreferences);
                        // set adapter
                        viewFavCourt.setLayoutManager(mLayoutFavourite);
                        viewFavCourt.setAdapter(courtFavAdapter);
                        courtFavAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<PagedCourtResponse> call, Throwable t) {

                }
            });
    }

 */

    // call api court size
    public void callSize() {
        CourtSizeRequest paramsRequest = new CourtSizeRequest();
        paramsRequest.setCurrentPage(1);
        paramsRequest.setVendorId(11);
        paramsRequest.setQueryString("");
        paramsRequest.setPageSize(10);

        Call<CourtSizeResponse> pagedSizeResponse = ApiClient.getCourtSizeService().getSize(AUTHORIZATION, paramsRequest.getVendorId(), paramsRequest.getPageSize(), paramsRequest.getQueryString(), paramsRequest.getCurrentPage());
        pagedSizeResponse.enqueue(new Callback<CourtSizeResponse>() {
            @Override
            public void onResponse(Call<CourtSizeResponse> call, Response<CourtSizeResponse> response) {
                if (response.code() == 200) {
                    CourtSizeResponse courtSizeResponse = response.body();
                    arrSizeResponse = (ArrayList<CourtSizeValue>) courtSizeResponse.getValue();
                    String status = "size";
                    for (CourtSizeValue coursize : arrSizeResponse) {
                        System.out.println(coursize.toString());
                    }

                    //get sharedPreference
                    SharedPreferences sh = getSharedPreferences("MySharedPref", 0);
                    SharedPreferences.Editor myEdit = sh.edit();

                    Gson gson = new Gson();
                    String json = gson.toJson(arrSizeResponse);
                    myEdit.putString("LIST_COURT_SIZE", json);
                    myEdit.commit(); // save to shared preference


                }
            }

            @Override
            public void onFailure(Call<CourtSizeResponse> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Đã có lỗi xảy ra !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //  call 2rating
    private void getHighRating(){
        PromotingHomeRequest paramsRequest = new PromotingHomeRequest();
        paramsRequest.setPageSize(10);

        Call<List<PromotingHomeResponse>> promotingHomeCall = ApiClient.getCourtService().getHighRatingCourtHome(AUTHORIZATION, paramsRequest.getPageSize());
        promotingHomeCall.enqueue(new Callback<List<PromotingHomeResponse>>() {
            @Override
            public void onResponse(Call<List<PromotingHomeResponse>> call, Response<List<PromotingHomeResponse>> response) {
                if(response.body().size()>0){
                    // set horizontal view
                    LinearLayoutManager mLayoutFavourite = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                    viewFavCourt.setLayoutManager(mLayoutFavourite);
                    viewFavCourt.setItemAnimator(new DefaultItemAnimator());
                    // handle
                    arrPromotingHome = response.body();
                    System.out.println("arr promo response "+ arrPromotingHome);
                    CourtFavouriteAdapter courtFavAdapter = new CourtFavouriteAdapter(HomeActivity.this, arrPromotingHome, sharedPreferences);
                    // set adapter
                    viewFavCourt.setLayoutManager(mLayoutFavourite);
                    viewFavCourt.setAdapter(courtFavAdapter);
                    courtFavAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<PromotingHomeResponse>> call, Throwable t) {

            }
        });
    }
}