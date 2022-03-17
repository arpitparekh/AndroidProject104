package com.arpitparekh.jan12androidproject.designing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.arpitparekh.jan12androidproject.databinding.ActivityDesignBinding;

public class DesignActivity extends AppCompatActivity {

    private ActivityDesignBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDesignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}