package com.example.tennis_booking_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.Booking.BookingDetail;
import com.example.tennis_booking_app.Models.Booking.BookingValue;
import com.example.tennis_booking_app.Models.Booking.Payment;
import com.example.tennis_booking_app.Models.Booking.PaymentDetail;
import com.example.tennis_booking_app.Models.CourtValue;
import com.example.tennis_booking_app.Models.Slot.SlotValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.ViewModels.Court.GetOneCourtRequest;
import com.example.tennis_booking_app.ViewModels.Court.GetOneCourtResponse;
import com.example.tennis_booking_app.ViewModels.Slot.SlotGetOneRequest;
import com.example.tennis_booking_app.ViewModels.Slot.SlotGetOneResponse;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichSuAdapter extends BaseAdapter {
    Context context;
    private SharedPreferences sharedPreferences;
    private List<BookingValue> bookingList;
    Token TOKEN;
    String AUTHORIZATION;

    public LichSuAdapter(Context context, SharedPreferences sharedPreferences, List<BookingValue> bookingList) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.bookingList = bookingList;
        //get sharedPreference
        sharedPreferences = context.getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sharedPreferences.getString("TOKEN", "");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();
    }

    @Override
    public int getCount() {
        return bookingList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_history, null);

        ImageView imgLogo = (ImageView) convertView.findViewById(R.id.imgLogo);
        TextView txtTenHis = (TextView) convertView.findViewById(R.id.txtTenHis);
        TextView txtCaHis = (TextView) convertView.findViewById(R.id.txtCaHis);
        TextView txtNgayGio = (TextView) convertView.findViewById(R.id.txtNgayGio);
        TextView txtTienHis = (TextView) convertView.findViewById(R.id.txtTienHis);

        List<BookingDetail> arrDetail = bookingList.get(position).getBookingDetail();
        if (arrDetail.size() >= 1) {
            for (int i = 0; i < arrDetail.size(); i++) {
                BookingDetail detail = arrDetail.get(i);
                int slotId = detail.getSlotId();
                int courtID = detail.getCourtId();
                txtNgayGio.setText(detail.getBookedPlayDate().substring(0, 10));
                txtTienHis.setText(detail.getTotalPriceAfterDiscount() + " vnd");
                GetOneCourtRequest paramRequest = new GetOneCourtRequest();

                paramRequest.setId(arrDetail.get(i).getCourtId());
                Call<GetOneCourtResponse> getOneCourtResponseCall = ApiClient.getCourtService().getOneCourt(AUTHORIZATION, paramRequest.getId());
                getOneCourtResponseCall.enqueue(new Callback<GetOneCourtResponse>() {
                    @Override
                    public void onResponse(Call<GetOneCourtResponse> call, Response<GetOneCourtResponse> response) {
                        if (response.body() != null) {
                            txtTenHis.setText(response.body().getName());
                        }
                    }


                    @Override
                    public void onFailure(Call<GetOneCourtResponse> call, Throwable t) {

                    }
                });

                SlotGetOneRequest paramCourt = new SlotGetOneRequest();
                paramCourt.setId(arrDetail.get(i).getSlotId());

                Call<SlotGetOneResponse> slotGetOneResponseCall = ApiClient.getSlotService().getOne(AUTHORIZATION, paramCourt.getId());
                slotGetOneResponseCall.enqueue(new Callback<SlotGetOneResponse>() {
                    @Override
                    public void onResponse(Call<SlotGetOneResponse> call, Response<SlotGetOneResponse> response) {
                        if (response.body() != null) {
                            txtCaHis.setText(response.body().getStartTime() + " - " + response.body().getEndTime());
                        }
                    }

                    @Override
                    public void onFailure(Call<SlotGetOneResponse> call, Throwable t) {

                    }
                });
            }
        } else {
            BookingDetail detail = arrDetail.get(0);
            int slotId = detail.getSlotId();
            int courtID = detail.getCourtId();
            txtNgayGio.setText(detail.getBookedPlayDate().substring(0, 10));
            txtTienHis.setText(detail.getTotalPriceAfterDiscount() + " vnd");
            GetOneCourtRequest paramRequest = new GetOneCourtRequest();

            paramRequest.setId(slotId);
            Call<GetOneCourtResponse> getOneCourtResponseCall = ApiClient.getCourtService().getOneCourt(AUTHORIZATION, paramRequest.getId());
            getOneCourtResponseCall.enqueue(new Callback<GetOneCourtResponse>() {
                @Override
                public void onResponse(Call<GetOneCourtResponse> call, Response<GetOneCourtResponse> response) {
                    if (response.body() != null) {
                        txtTenHis.setText(response.body().getName());
                    }
                }


                @Override
                public void onFailure(Call<GetOneCourtResponse> call, Throwable t) {

                }
            });

            SlotGetOneRequest paramCourt = new SlotGetOneRequest();
            paramCourt.setId(courtID);

            Call<SlotGetOneResponse> slotGetOneResponseCall = ApiClient.getSlotService().getOne(AUTHORIZATION, paramCourt.getId());
            slotGetOneResponseCall.enqueue(new Callback<SlotGetOneResponse>() {
                @Override
                public void onResponse(Call<SlotGetOneResponse> call, Response<SlotGetOneResponse> response) {
                    if (response.body() != null) {
                        txtCaHis.setText(response.body().getStartTime() + " - " + response.body().getEndTime());
                    }
                }

                @Override
                public void onFailure(Call<SlotGetOneResponse> call, Throwable t) {

                }
            });
        }

        /*  txtTenHis.setText(bookingValue.getId());
        txtCaHis.setText(bookingValue.getBookingDetail().get(position).getSlotId());
        txtTienHis.setText(bookingValue.getTotalPrice());*/

        return convertView;

        /*BookingValue booking=bookingList.get(position);
        CourtValue court=new CourtValue(booking.getBookingDetail().get(position).getCourtId());
        SlotValue slot=new SlotValue(booking.getBookingDetail().get(position).getSlotId());

        txtTenHis.setText(court.getName());
        txtCaHis.setText(slot.getStartTime().getHours() + slot.getEndTime().getHours());*/

        /*txtTenHis.setText(booking.getBookingDetail().get(position).getSlotId());

        txtCaHis.setText(booking.getBooking().getSlotId());
        txtNgayGio.setText(booking.get);
        txtTienHis.setText(booking.getTotalPrice());
        mgLogo.setImageResource(history.getAnh());*/
    }

//    private void loadNameCourt(int courtID){
//
//    }
}
