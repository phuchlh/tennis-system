package com.example.tennis_booking_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.LoadImage;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.Models.Voucher;
import com.example.tennis_booking_app.PhucHLH.CourtDiscount;
import com.example.tennis_booking_app.PhucHLH.CourtDiscountHorizontalAdapter;
import com.example.tennis_booking_app.ViewModels.CourtSize.CourtSizeRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.example.tennis_booking_app.ViewModels.Vendor.VendorRequest;
import com.example.tennis_booking_app.ViewModels.Vendor.VendorResponse;
import com.example.tennis_booking_app.ViewModels.Voucher.VoucherRequest;
import com.example.tennis_booking_app.ViewModels.Voucher.VoucherResponse;
import com.example.tennis_booking_app.activity.home.HomeActivity;
import com.example.tennis_booking_app.adapter.home.HorizontalAdapter;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPromotion extends AppCompatActivity {
    ListView lvSanKM;
    SanKmAdapter adapter;
    TextView txtTotalRate, txtVendorName, txtDistance, txtRating;

    ImageView imgStore;
    RecyclerView viewCourtPromo;
    RecyclerView viewPromoCourt;
    CourtDiscountHorizontalAdapter courtDiscountHorizontalAdapter;
    List<CourtDiscount> arrCourtDiscount;
    ArrayList<SanKM> arrSanKM;
    Token TOKEN;
    String AUTHORIZATION;
    SharedPreferences sharedPreferences;
    List<PagedCourtValue> arrResponseOfOneVendor;
    List<Voucher> arrVoucher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_promotion);

        lvSanKM = (ListView) findViewById(R.id.lvSanKM);
        txtTotalRate = findViewById(R.id.txtTotalRate);
        txtVendorName = findViewById(R.id.txtVendorName);
        txtDistance = findViewById(R.id.txtDistance);
        txtRating = findViewById(R.id.txtRatingAndComment);
        imgStore = findViewById(R.id.imgStore);
        viewCourtPromo = findViewById(R.id.viewCourtPromo);

        // horizontal view promo
        viewPromoCourt = (RecyclerView) findViewById(R.id.viewCourtPromo);
//        arrCourtDiscount = new ArrayList<>();
//        courtDiscountHorizontalAdapter = new CourtDiscountHorizontalAdapter(arrCourtDiscount, this);
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        viewPromoCourt.setLayoutManager(mLayoutManager);
//        viewPromoCourt.setItemAnimator(new DefaultItemAnimator());
//        viewPromoCourt.setAdapter(courtDiscountHorizontalAdapter);
//        initdata();
        // end of horizontal view promo


        //get sharedPreference
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sharedPreferences.getString("TOKEN", "");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();

        // get bundle from home
        Intent intent = getIntent();
        int vendorID = intent.getIntExtra("vendorID", -1);
        checkVendorID(vendorID);
        txtRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsPromotion.this, DanhGia.class);
                startActivity(intent);
            }
        });
        txtRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsPromotion.this, DanhGia.class);
                startActivity(intent);
            }
        });

        lvSanKM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SanKM sanKM = arrSanKM.get(position);
                Intent intent = new Intent(DetailsPromotion.this, Booking.class);
//                intent.putExtra("sanKMDetail", (Serializable) sanKM);
                startActivity(intent);
            }
        });

        lvSanKM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                PagedCourtValue value = new PagedCourtValue();

            }
        });


    }

//    private void initdata() {
//        arrCourtDiscount.add(new CourtDiscount("Kh??ch Quen Th??n Y??u", "Gi???m 20.000??", R.drawable.tennis_clay, "Nh???p m?? KHACHQUEN ????? ???????c ??u ????i 20.000?? khi ?????t s??n t??? 3 l???n tr??? l??n"));
//        arrCourtDiscount.add(new CourtDiscount("Cu???i Tu???n Vui V???", "Gi???m 30.000??", R.drawable.tennis_grass, "Nh???p m?? CUOITUAN ????? ???????c ??u ????i 30.000?? khi ?????t s??n v??o T7 & Ch??? Nh???t"));
//        arrCourtDiscount.add(new CourtDiscount("M???i b???n L???n ?????u", "Gi???m 50.000??", R.drawable.tennis_grass, "Nh???p m?? LANDAU ????? ???????c ??u ????i 50.000?? khi ?????t s??n l???n ?????u"));
//        courtDiscountHorizontalAdapter.notifyDataSetChanged();
//    }

    private void checkVendorID(int vendorID) {
        if (vendorID == -1) {
            Toast.makeText(this, "Kh??ng t??m ???????c s??n, th??? l???i", Toast.LENGTH_SHORT).show();
        } else {
            getVendorByID(vendorID);
            loadCourtByVendorID(vendorID);
            loadVoucher(vendorID);
        }
    }

    private void getVendorByID(int vendorID) {
        VendorRequest vendorRequest = new VendorRequest();
        vendorRequest.setPageSize(vendorID);
        System.out.println("vendor id + " + vendorID);

        Call<VendorResponse> vendorResponseCall = ApiClient.getVendorService().getOneVendor(AUTHORIZATION, vendorRequest.getPageSize());
        System.out.println("request url \n" + vendorResponseCall.request().url());
        vendorResponseCall.enqueue(new Callback<VendorResponse>() {
            @Override
            public void onResponse(Call<VendorResponse> call, Response<VendorResponse> response) {
                try {
                    VendorResponse vendorResponse = response.body();
                    txtVendorName.setText(vendorResponse.getVendorName());
                    txtDistance.setText(vendorResponse.getDistance());
                    if (vendorResponse.getRatingAverage() == 0) {
                        txtTotalRate.setText(String.valueOf(1));
                    } else {
                        txtTotalRate.setText(vendorResponse.getRatingAverage() + "");
                    }
                    String imageURL = vendorResponse.getAvatarUrl();
                    LoadImage loadImage = new LoadImage(imgStore);
                    loadImage.execute(imageURL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<VendorResponse> call, Throwable t) {

            }
        });
    }

    private void loadCourtByVendorID(int vendorID){
        PagedCourtRequest paramsRequest = new PagedCourtRequest();
        paramsRequest.setVendorId(vendorID);
        paramsRequest.setPageSize(6);
        paramsRequest.setQueryString("");
        paramsRequest.setCurrentPage(1);
                                                                // PagedList?VendorId=11&PageSize=6&queryString=z&CurrentPage=1
        Call<PagedCourtResponse> pagedCourtResponseCall = ApiClient.getCourtService().getPagedList(AUTHORIZATION, paramsRequest.getVendorId(), paramsRequest.getPageSize(), paramsRequest.getQueryString(), paramsRequest.getCurrentPage());
        pagedCourtResponseCall.enqueue(new Callback<PagedCourtResponse>() {
            @Override
            public void onResponse(Call<PagedCourtResponse> call, Response<PagedCourtResponse> response) {
                if(response.body() != null){
                    arrResponseOfOneVendor = new ArrayList<>();
                    arrResponseOfOneVendor = response.body().getValue();
                    SanKmAdapter sanKmAdapter = new SanKmAdapter(DetailsPromotion.this, arrResponseOfOneVendor, sharedPreferences);
                    lvSanKM.setAdapter(sanKmAdapter);
                }
            }

            @Override
            public void onFailure(Call<PagedCourtResponse> call, Throwable t) {

            }
        });
    }

    private void loadVoucher(int vendorID){
        VoucherRequest paramsRequest = new VoucherRequest();
        paramsRequest.setVendorId(vendorID);

        Call<VoucherResponse> vendorResponseCall = ApiClient.getVoucherService().getPagedVoucher(AUTHORIZATION, paramsRequest.getVendorId());
        vendorResponseCall.enqueue(new Callback<VoucherResponse>() {
            @Override
            public void onResponse(Call<VoucherResponse> call, Response<VoucherResponse> response) {
                if(response.body() !=null){
                    // set horizontal view
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    // handle API
                    arrVoucher = response.body().getValue();
                    System.out.println("voucher value " + arrVoucher);
                    courtDiscountHorizontalAdapter = new CourtDiscountHorizontalAdapter(arrVoucher, DetailsPromotion.this);
                    // display horizontal view
                    viewPromoCourt.setLayoutManager(mLayoutManager);
                    viewPromoCourt.setItemAnimator(new DefaultItemAnimator());
                    viewPromoCourt.setAdapter(courtDiscountHorizontalAdapter);
                    courtDiscountHorizontalAdapter.notifyDataSetChanged();

                    // send data to confirm booking
//                    Bundle bundle = new Bundle();
//                    Intent intentVoucher = new Intent(DetailsPromotion.this, ConfirmBooking.class);
//                    bundle.putSerializable("voucherARR", (Serializable) arrVoucher);
//                    intentVoucher.putExtra("voucher", bundle);
//                    startActivity(intentVoucher);
                }
            }

            @Override
            public void onFailure(Call<VoucherResponse> call, Throwable t) {

            }
        });
    }
}