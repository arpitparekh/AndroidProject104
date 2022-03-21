package com.arpitparekh.jan12androidproject.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.arpitparekh.jan12androidproject.R;
import android.os.Bundle;

import com.arpitparekh.jan12androidproject.databinding.ActivityHolderBinding;
import com.arpitparekh.jan12androidproject.databinding.ActivitySplashScreenBinding;

public class HolderActivity extends AppCompatActivity {

    private ActivityHolderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHolderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Holder Activity");

        // FragmentManager class

        // FragmentTransaction class

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.fcvHolder,new MeraFragment());
        ft.commit();


    }
}