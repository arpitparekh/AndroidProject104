package com.arpitparekh.jan12androidproject.fragment_new_way;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.arpitparekh.jan12androidproject.databinding.ActivityAnotherHolderBinding;

public class AnotherHolderActivity extends AppCompatActivity {

    private ActivityAnotherHolderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnotherHolderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

}