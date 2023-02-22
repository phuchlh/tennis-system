package com.example.tennis_booking_app.Clients;

import androidx.annotation.NonNull;

import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.Service.BookingService;
import com.example.tennis_booking_app.Service.CourtSizeService;
import com.example.tennis_booking_app.Service.SlotService;
import com.example.tennis_booking_app.Service.UserService;
import com.example.tennis_booking_app.Service.CourtService;
import com.example.tennis_booking_app.Service.VendorService;
import com.example.tennis_booking_app.Service.VoucherService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BEARER_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL2dyb3Vwc2lkIjoiIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiIzMiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJwaHVjaGxoMSIsImZhbWlseV9uYW1lIjoiSG9uZyBQaHVjIiwiaWF0IjoiNy8xMy8yMDIyIDM6MTQ6MDUgQU0iLCJqdGkiOiI3YzdjYjIzOC0yM2FlLTRkNjgtODhmOS00MDA1ZGU5ZjAwOWMiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJub3JtYWxVc2VyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwOS8wOS9pZGVudGl0eS9jbGFpbXMvYWN0b3IiOiIzIiwiZXhwIjoxNjg5MTkyODQ1LCJpc3MiOiJodHRwczovL2h1dm55LnRlY2giLCJhdWQiOiJodHRwczovL2h1dm55LnRlY2gifQ.ajxshCp0KqBea7hWQ28mMhX_mYpuOhTMJuVL3WWFCDc";


    private static Retrofit getRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://coreapi.softek.com.vn/api/")
                .client(okHttpClient)
                .build();
    }

    /*private static Retrofit getRetrofit(){
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + BEARER_TOKEN)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl("https://coreapi.softek.com.vn/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    */

    public static UserService getUserService() {
        return getRetrofit().create(UserService.class);
    }

    public static CourtService getCourtService() {
        return getRetrofit().create(CourtService.class);
    }

    public static CourtSizeService getCourtSizeService(){
        return getRetrofit().create(CourtSizeService.class);
    }

    public static VendorService getVendorService(){
        return getRetrofit().create(VendorService.class);
    }
    public static BookingService getBookingService(){
        return getRetrofit().create(BookingService.class);
    }
    public static SlotService getSlotService(){
        return getRetrofit().create(SlotService.class);
    }

    public static VoucherService getVoucherService(){
        return getRetrofit().create(VoucherService.class);
    }
}
