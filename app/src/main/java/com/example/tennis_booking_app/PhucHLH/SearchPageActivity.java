package com.example.tennis_booking_app.PhucHLH;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tennis_booking_app.R;

public class SearchPageActivity extends AppCompatActivity {

    EditText txtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        txtSearch = (EditText) findViewById(R.id.txtSearch);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
        }

        txtSearch.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String searchText = txtSearch.getText().toString().trim();
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    Intent intent = new Intent(SearchPageActivity.this, SpecificCourtsActivity.class);
                    intent.putExtra("sandetail", searchText);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}