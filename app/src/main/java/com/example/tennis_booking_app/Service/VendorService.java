package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.Vendor.VendorResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface VendorService {
    String VENDOR = "Vendor";

    @GET(VENDOR + "/GetPromotingVendorHome")
    Call<List<VendorResponse>> getPromotingVendorHome(@Header("Authorization") String access_token, @Query("pageSize") int pageSize);

    @GET(VENDOR + "/GetOne")
    Call<VendorResponse> getOneVendor(@Header("Authorization") String access_token, @Query("Id") int Id);
}
