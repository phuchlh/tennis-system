package com.example.tennis_booking_app.Service;

import com.example.tennis_booking_app.ViewModels.Court.CourtRespone;
import com.example.tennis_booking_app.ViewModels.Court.GetOneCourtResponse;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtRequest;
import com.example.tennis_booking_app.ViewModels.PagedCourt.PagedCourtResponse;
import com.example.tennis_booking_app.ViewModels.PromotingCourtHome.PromotingHomeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CourtService {
    String COURT = "Court";

    @GET(COURT + "/GetPagedList")
    Call<CourtRespone> getCourt(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);

    @GET(COURT + "/GetPagedListPromotingCourt")
    Call<PagedCourtResponse> getPagedPromoCourt(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);

    @GET(COURT + "/GetPagedListHighRatingCourt")
    Call<PagedCourtResponse> getPagedListHighRating(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);

    @GET(COURT + "/GetPagedListCourtByType")
    Call<PagedCourtResponse> getPagedListCourtByType(@Header("Authorization") String access_token, @Query("PageSize") int PageSize, @Query("CurrentPage") int CurrentPage, @Query("typeId") int typeId);

    @GET(COURT + "/PagedList")
    Call<PagedCourtResponse> getPagedList(@Header("Authorization") String access_token, @Query("VendorId") int VendorId, @Query("PageSize") int pagesize, @Query("queryString") String queryString, @Query("CurrentPage") int currentPage);

    @GET(COURT + "/GetHighRatingCourtHome")
    Call<List<PromotingHomeResponse>> getHighRatingCourtHome(@Header("Authorization") String access_token, @Query("PageSize") int pagesize);

    @GET(COURT + "/GetOne")
    Call<GetOneCourtResponse> getOneCourt(@Header("Authorization") String access_token, @Query("Id") int Id);
}
