package com.arpitparekh.jan12androidproject.activity_switch_explicit;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.jan12androidproject.R;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Second");

    }
}