package com.arpitparekh.jan12androidproject.viewBinding_dataBinding;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.jan12androidproject.databinding.ActivityMyBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends AppCompatActivity {

    private ActivityMyBinding binding;  // class level declaration
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // viewBinding

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}