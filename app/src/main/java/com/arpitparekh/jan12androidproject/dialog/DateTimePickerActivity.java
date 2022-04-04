package com.arpitparekh.jan12androidproject.dialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;

import com.arpitparekh.jan12androidproject.databinding.ActivityDateTimePickerBinding;

public class DateTimePickerActivity extends AppCompatActivity {

    private ActivityDateTimePickerBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateTimePickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {

            }
        });
    }
}