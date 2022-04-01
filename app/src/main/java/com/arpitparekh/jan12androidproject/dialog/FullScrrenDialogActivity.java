package com.arpitparekh.jan12androidproject.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityFullScrrenDialogBinding;

public class FullScrrenDialogActivity extends AppCompatActivity {

    private ActivityFullScrrenDialogBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullScrrenDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnFullScreen.setOnClickListener(view -> {

            MyDialog dialog = new MyDialog();

            dialog.show(getSupportFragmentManager(),"hello");

        });

    }
}