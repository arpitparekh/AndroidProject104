package com.arpitparekh.jan12androidproject.string_transfer_activity;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.jan12androidproject.R;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class GoaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_goa);

        TextView tv = findViewById(R.id.tvSomething);

        Intent i = getIntent();

        String another = i.getStringExtra("data");

        tv.setText(another);

    }
}