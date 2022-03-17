package com.arpitparekh.jan12androidproject.object_transfer_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.arpitparekh.jan12androidproject.R;
public class DusriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dusri);

        TextView tv = findViewById(R.id.tvObject);

        Intent i = getIntent();

        Student s = (Student) i.getSerializableExtra("data");

        tv.setText(s.name+"\n"+s.address);

    }
}