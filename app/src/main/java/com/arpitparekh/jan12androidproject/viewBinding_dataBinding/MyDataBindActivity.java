package com.arpitparekh.jan12androidproject.viewBinding_dataBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.arpitparekh.jan12androidproject.databinding.ActivityMyDataBindBinding;

public class MyDataBindActivity extends AppCompatActivity {

    private ActivityMyDataBindBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDataBindBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // data binding

        // is used to load class data into layout

        binding.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name =  binding.edtName.getText().toString();
                String address = binding.edtAddress.getText().toString();

                Emp e = new Emp(name,address);

                binding.setObj(e);  // data binding

            }
        });

    }
}