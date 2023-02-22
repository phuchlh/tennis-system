package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.Voucher.VoucherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface VoucherService {

    @GET("Voucher/PagedList")
    Call<VoucherResponse> getPagedVoucher(@Header("Authorization") String access_token, @Query("VendorId") int VendorId);
}
