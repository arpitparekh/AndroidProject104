package com.arpitparekh.jan12androidproject.cordinator_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.arpitparekh.jan12androidproject.databinding.ActivityMyCoBinding;
import com.google.android.material.snackbar.Snackbar;

public class MyCoActivity extends AppCompatActivity {

    private ActivityMyCoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // lamda method  // { int a -> print() }

        binding.fab3.setOnClickListener(view -> {

            Snackbar.make(view,"This is snackbar",Snackbar.LENGTH_SHORT).show();

        });

    }
}