package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.Login.LoginRequest;
import com.example.tennis_booking_app.ViewModels.Login.LoginResponse;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.example.tennis_booking_app.ViewModels.Register.RegisterRequest;
import com.example.tennis_booking_app.ViewModels.Register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {


    @POST("User/SignIn")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("User/Register")
    Call<RegisterResponse> userRegister(@Body RegisterRequest registerRequest);
}