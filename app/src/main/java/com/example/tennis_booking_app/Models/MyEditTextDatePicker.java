package com.example.tennis_booking_app.Models;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.TimeZone;

public class MyEditTextDatePicker implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    EditText edtDate;
    private int dd;
    private int MM;
    private int yyyy;
    Context context;

    public MyEditTextDatePicker(EditText edtDate, int dd, int MM, int yyyy, Context context) {
        this.edtDate = edtDate;
        this.dd = dd;
        this.MM = MM;
        this.yyyy = yyyy;
        this.context = context;
        updateDisplay();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        yyyy = year;
        MM = month;
        dd = dayOfMonth;
    }

    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        DatePickerDialog dialog = new DatePickerDialog(context, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void updateDisplay(){
        edtDate.setText(new StringBuilder().append(dd).append("/").append(MM+1).append("/").append(yyyy).append(" "));
    }
}
