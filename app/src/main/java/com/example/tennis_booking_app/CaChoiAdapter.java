package com.example.tennis_booking_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.tennis_booking_app.ViewModels.Slot.SlotResponse;

import java.util.List;

public class CaChoiAdapter extends BaseAdapter {

    private Context context;
    SharedPreferences sharedPreferences;
    private List<SlotResponse> arrSlot;

    public CaChoiAdapter(Context context, List<SlotResponse> arrSlot, SharedPreferences sharedPreferences) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.arrSlot = arrSlot;
    }

    @Override
    public int getCount() {
        return arrSlot.size();
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
        convertView = inflater.inflate(R.layout.list_ca_choi, null);

        TextView txtSlot = (TextView) convertView.findViewById(R.id.btSLot);
        TextView txtThoiluong = (TextView) convertView.findViewById(R.id.txtThoi);
        TextView txtGia = (TextView) convertView.findViewById(R.id.txtGia);
        CheckBox cbCachoi = (CheckBox) convertView.findViewById(R.id.cbCaChoi);
        cbCachoi.setFocusable(false);

        SlotResponse slot = arrSlot.get(position);
        cbCachoi.setClickable(slot.getStatusId() == 2 || slot.getStatusId() == 3 ? false : true);

        String startTime = slot.getStartTime().substring(0, 5);
        String endTime = slot.getEndTime().substring(0, 5);
        txtThoiluong.setText(startTime + " - "+ endTime);
        txtGia.setText(slot.getPrice()+"");
        txtSlot.setText(slot.getNo()+"");

       /* SlotValue caChoi=caChoiList.get(position);

        btCa.setText(caChoi.getNo());
        txtThoiluong.setText(caChoi.getStartTime().toString() + caChoi.getEndTime().toString());
        txtGia.setText(caChoi.getPrice());*/


        /*if(caChoi.getStatus() == 2) {

            btCa.setTextColor(R.drawable.green);
            txtThoiluong.setTextColor(R.drawable.green);
            txtGia.setTextColor(R.drawable.green);
            cbCachoi.setVisibility(View.INVISIBLE);

        }else {
            cbCachoi.setVisibility(View.VISIBLE);
        }

        btCa.setText(caChoi.getSlot());
        txtThoiluong.setText(caChoi.getThoiluong());
        txtGia.setText(caChoi.getPriceByName());*/

        return convertView;
    }
}
