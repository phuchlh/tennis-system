package com.example.tennis_booking_app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tennis_booking_app.Clients.ApiClient;
import com.example.tennis_booking_app.Models.PagedCourtValue;
import com.example.tennis_booking_app.Models.Token;
import com.example.tennis_booking_app.ViewModels.Slot.SlotRequest;
import com.example.tennis_booking_app.ViewModels.Slot.SlotResponse;
import com.google.gson.Gson;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Booking extends AppCompatActivity {
    TextView edtTime;
    TextView txtTennis;
    ListView lvCaChoi;
    CaChoiAdapter adapter;
    //ArrayList<CaChoi> arrCachoi;
    List<SlotResponse> arrSlot;
    Intent intent, intentKM, intentOBJ;
    ArrayList<SlotResponse> arrSlotSelected;
    Button btOK;
    CheckBox cbCachoi;
    Token TOKEN;
    String AUTHORIZATION;
    String timeTaken;
    SharedPreferences sharedPreferences;
    PagedCourtValue value;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        txtTennis = (TextView) findViewById(R.id.txtTennis);
        edtTime = findViewById(R.id.edtTime);
        lvCaChoi = (ListView) findViewById(R.id.lvCaChoi);
        btOK = (Button) findViewById(R.id.btOK);
        cbCachoi = (CheckBox) findViewById(R.id.cbCaChoi);
        arrSlotSelected = new ArrayList<>();

        intent = getIntent();
        intentKM = getIntent();

        SanTennis ten = (SanTennis) intent.getSerializableExtra("sandetail");
        SanKM sanKM = (SanKM) intentKM.getSerializableExtra("sanKMDetail");

        intentOBJ = getIntent();
        value = (PagedCourtValue) intentOBJ.getSerializableExtra("courtOBJ");
        txtTennis.setText(value.getName());

        //CaChoi caChoi = (CaChoi) intent.getSerializableExtra("cachoi");

        sharedPreferences = getSharedPreferences("MySharedPref", 0);
        //parse JSON TOKEN to object Token
        Gson gson = new Gson();
        String json = sharedPreferences.getString("TOKEN", "");
        TOKEN = gson.fromJson(json, Token.class);
        AUTHORIZATION = "Bearer " + TOKEN.getAccessToken();

        edtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int dd = calendar.get(Calendar.DATE);
                int MM = calendar.get(Calendar.MONTH);
                int yyyy = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Booking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        calendar.set(year, month, day);
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        timeTaken = simpleDateFormat.format(calendar.getTime());
                        edtTime.setText(timeTaken);
                        System.out.println("fsfwefefe " + timeTaken);
                        LoadSlot(timeTaken);
                    }
                }, yyyy, MM, dd);
                datePickerDialog.show();
            }
        });

        lvCaChoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SlotResponse slot = arrSlot.get(position);
                CheckBox cb_slot = (CheckBox) view.findViewById(R.id.cbCaChoi);

                if (cb_slot.getVisibility() == View.VISIBLE) {
                    if (cb_slot.isChecked()) {
                        cb_slot.setChecked(false);
                        if (arrSlot.size() > 0) {
                            for (SlotResponse caChoi : arrSlot) {
                                if (caChoi.getId() == slot.getId()) {
                                    arrSlot.remove(caChoi);
                                }
                            }
                        }
                    } else {
                        cb_slot.setChecked(true);
                        addSelectedSlot(slot);
                    }
                }
            }
        });


        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrSlotSelected.size() == 0) {
                    Toast.makeText(Booking.this, "Xin vui lòng chọn ca chơi !", Toast.LENGTH_LONG).show();
                } else {
                    Intent intentConfirm = new Intent(Booking.this, ConfirmBooking.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("arrSlotSelected", (Serializable) arrSlotSelected);
                    bundle.putSerializable("courtValue", (Serializable) value);
                    bundle.putString("datePick", edtTime.getText().toString().trim());
                    intentConfirm.putExtra("data", bundle);
                    startActivity(intentConfirm);
                }
            }
        });
    }

    private void addSelectedSlot(SlotResponse ca) {
        System.out.println("ca choi " + ca);
        arrSlotSelected.add(ca);
        System.out.println("size: " + arrSlotSelected.size());
        for (SlotResponse cachoi : arrSlotSelected) {
            System.out.println(cachoi.toString());
        }
    }


    private void LoadSlot(String time) {
        SlotRequest param_request = new SlotRequest();
        param_request.setVendorId(value.getVendorId());
        param_request.setCourtId(value.getId());
        param_request.setBookedPlayDate(time);
        System.out.println("time taken + " + time);
        param_request.setCourtTypeId(value.getCourtSizeId());
        Call<List<SlotResponse>> slotResponeCall = ApiClient.getSlotService().getSlotbyDate(AUTHORIZATION, param_request.getVendorId(), param_request.getCourtId(), param_request.getBookedPlayDate(), param_request.getCourtTypeId());
        slotResponeCall.enqueue(new Callback<List<SlotResponse>>() {
            @Override
            public void onResponse(Call<List<SlotResponse>> call, Response<List<SlotResponse>> response) {
                if (response.body().size() > 0) {
                    arrSlot = response.body();
                    CaChoiAdapter adapter = new CaChoiAdapter(Booking.this, arrSlot, sharedPreferences);
                    lvCaChoi.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<SlotResponse>> call, Throwable t) {

            }
        });
    }

}