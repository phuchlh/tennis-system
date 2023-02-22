package com.example.tennis_booking_app;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.Booking.BookingDetail;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.Models.Voucher;
import com.example.tennis_booking_app.ViewModels.Booking.BookingRequest;
import com.example.tennis_booking_app.ViewModels.Booking.BookingResponse;
import com.example.tennis_booking_app.ViewModels.Slot.SlotResponse;
import com.example.tennis_booking_app.ViewModels.Voucher.VoucherRequest;
import com.example.tennis_booking_app.ViewModels.Voucher.VoucherResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmBooking extends AppCompatActivity {
    TextView txtVendorID, txtCourtName, txtDientich2,
            txtSlot, txtGia, txtNgay, txtThanhGia, txtTongGia, txtUuDai;
    TextView edtPromo;
    Button btNhan, btKM1, btKM2, btKM3;
    Intent intent1, intentKM, intentValue, intentVoucher;
    List<SlotResponse> arrSelected;
    int sum = 0;
    PagedCourtValue courtValue;
    List<Voucher> arrVoucher;
    Token TOKEN;
    String AUTHORIZATION;
    SharedPreferences sharedPreferences;
    ListView lvVoucher;

    TextView txtCourtNameHorizontalPromo, txtDiscount;
    Voucher voucherSelected;
    SharedPreferences shs;
    String datePick;
    List<BookingDetail> arrBooking;
    List<BookingResponse> arrBookingResponse;
    Voucher voucherClick = new Voucher();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        txtVendorID = (TextView) findViewById(R.id.txtVendorID);
        txtCourtName = (TextView) findViewById(R.id.txtCourtName);
        txtDientich2 = (TextView) findViewById(R.id.txtDientich2);
        txtSlot = (TextView) findViewById(R.id.txtSlot);
        txtGia = (TextView) findViewById(R.id.txtGia);
        txtThanhGia = (TextView) findViewById(R.id.txtThanhGia);
        txtTongGia = (TextView) findViewById(R.id.txtTongGia);
        txtNgay = (TextView) findViewById(R.id.txtNgay);
        txtUuDai = (TextView) findViewById(R.id.txtUuDai);
        edtPromo = (TextView) findViewById(R.id.edtPromo);
        btNhan = (Button) findViewById(R.id.btnXacNhan);
        arrBooking = new ArrayList<>();


        intent1 = getIntent();
        intentKM = getIntent();
        intentValue = getIntent();
        intentVoucher = getIntent();

        //SanTennis ten2 = (SanTennis) intent1.getSerializableExtra("sandetail2");
//        SanKM tenKM = (SanKM) intentKM.getSerializableExtra("sandetailKM");

        Intent intentConfirm = getIntent();
        Bundle bundleConfirm = intentConfirm.getBundleExtra("data");
        arrSelected = (List<SlotResponse>) bundleConfirm.getSerializable("arrSlotSelected");
        courtValue = (PagedCourtValue) bundleConfirm.getSerializable("courtValue");
        datePick = (String) bundleConfirm.getString("datePick");





//        loadVoucher(courtValue.getVendorId());


        //get sharedPreference
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sharedPreferences.getString("TOKEN", "");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();




        if (courtValue != null) {
            txtVendorID.setText(courtValue.getName());
            txtCourtName.setText(courtValue.getName());
//            txtDientich2.setText(courtValue.getDientich());
            if (arrSelected.size() > 0) {
                String selected_slot = "";
                String selected_slot_price = "";

                for (SlotResponse caChoi : arrSelected) {
                    selected_slot += caChoi.getStartTime() + ", ";
                    selected_slot_price += caChoi.getPrice() + ", ";
                    sum += Integer.parseInt(caChoi.getPrice() + "");

                }

                txtSlot.setText(selected_slot);
                txtGia.setText(selected_slot_price);
                txtThanhGia.setText(sum + " vnđ");
                txtTongGia.setText(sum + " vnđ");
            }
            txtNgay.setText(datePick);
        }

        edtPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadVoucher(courtValue.getVendorId());
            }

        });


//        btNhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent1 = new Intent(ConfirmBooking.this, ChucMung.class);
//                startActivity(intent1);
//            }
//        });

        btNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vendorID = courtValue.getVendorId();
                int tongGia = Integer.parseInt(txtTongGia.getText().toString().substring(0, txtTongGia.getText().length()-3).trim());
                int thanhGia = Integer.parseInt(txtThanhGia.getText().toString().substring(0, txtThanhGia.length()-3).trim());
                int voucherId = voucherClick.getId();

                booking(vendorID, tongGia, thanhGia, voucherId);
            }
        });

    }



    private void loadVoucher(int vendorID) {

        VoucherRequest paramsRequest = new VoucherRequest();
        paramsRequest.setVendorId(vendorID);

        Call<VoucherResponse> vendorResponseCall = ApiClient.getVoucherService().getPagedVoucher(AUTHORIZATION, paramsRequest.getVendorId());
        vendorResponseCall.enqueue(new Callback<VoucherResponse>() {
            @Override
            public void onResponse(Call<VoucherResponse> call, Response<VoucherResponse> response) {
                if (response.body() != null) {
                    arrVoucher = response.body().getValue();
                    Dialog dialog = new Dialog(ConfirmBooking.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_khuyen_mai);
                    dialog.setCanceledOnTouchOutside(true);


                    lvVoucher=dialog.findViewById(R.id.lvVoucher);
                    DialogVoucherAdapter voucherAdapter = new DialogVoucherAdapter(dialog.getContext(), arrVoucher, sharedPreferences);
                    lvVoucher.setAdapter(voucherAdapter);

                    lvVoucher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            voucherClick = arrVoucher.get(position);
                            System.out.println("voucher click = " + voucherClick);
                            edtPromo.setText(voucherClick.getName());
                            dialog.dismiss();
                            String gia = txtThanhGia.getText().toString().substring(0, txtThanhGia.getText().length()-3);
                            System.out.println("giaaaaaaaaaaaaaaaa " + gia);
                            int ketqua = Integer.parseInt(gia.trim()) - (voucherClick.getDiscountPrice());
                            txtUuDai.setText(String.valueOf(voucherClick.getDiscountPrice())+ " vnd");
                            txtTongGia.setText(String.valueOf(ketqua)+" vnd");
                        }
                    });
                    dialog.show();
                }
            }

            @Override
            public void onFailure(Call<VoucherResponse> call, Throwable t) {

            }
        });
    }

    private void booking(int vendorID, int tongGia, int thanhGia, int voucherId){
        BookingRequest paramsRequest = new BookingRequest();
        paramsRequest.setVendorId(vendorID);
        paramsRequest.setTotalPrice(tongGia);
        paramsRequest.setNote("Đặt sân");
        paramsRequest.setStatusId(1);
        paramsRequest.setReasonOfChange("tạo mới");
        // courtValue.getName()
        for (SlotResponse slot : arrSelected) {
            int courtId = courtValue.getId();
            int slotId = slot.getId();
            int totalPrice = thanhGia;
            int totalPriceAfterDiscount = tongGia;
            int statusId = 1;
            boolean active = true;
            int ratedStar = 0;
            String note = "Đặt sân";
            BookingDetail bookingDetail = new BookingDetail(courtId, slotId, datePick, totalPrice, totalPriceAfterDiscount, voucherId, statusId, active, ratedStar, note);
            arrBooking.add(bookingDetail);
            System.out.println("booking detail "+ bookingDetail.getNote());
        }
        paramsRequest.setBookingDetail(arrBooking);

        Call<BookingResponse> bookingRequestCall = ApiClient.getBookingService().bookingOneCourt(AUTHORIZATION, paramsRequest);
        bookingRequestCall.enqueue(new Callback<BookingResponse>() {
            @Override
            public void onResponse(Call<BookingResponse> call, Response<BookingResponse> response) {
                if(response.body() != null){
                    BookingResponse bookingResponse = response.body();
                    Intent intentSuccess = new Intent(ConfirmBooking.this, ChucMung.class);
                    startActivity(intentSuccess);
                }
            }

            @Override
            public void onFailure(Call<BookingResponse> call, Throwable t) {

            }
        });
    }
}