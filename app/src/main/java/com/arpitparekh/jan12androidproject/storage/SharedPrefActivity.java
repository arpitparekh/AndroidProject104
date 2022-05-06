package com.arpitparekh.jan12androidproject.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.databinding.ActivitySharedPrefBinding;

public class SharedPrefActivity extends AppCompatActivity {

    private ActivitySharedPrefBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharedPrefBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // primitive datatype

        // int // long // float  // boolean  // String //

        // key value pair

        binding.btnStoreShared.setOnClickListener(view -> {

            SharedPreferences preference = getSharedPreferences("primitive",MODE_PRIVATE);

            SharedPreferences.Editor editor = preference.edit();

            editor.putInt("int",23);

            editor.apply();

            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

        });

        binding.btnFetchShared.setOnClickListener(view -> {

            SharedPreferences preference = getSharedPreferences("primitive",MODE_PRIVATE);

            int result = preference.getInt("int",0);

            binding.tvShared.setText(String.valueOf(result));

        });

        binding.btnClearShared.setOnClickListener(view -> {

            SharedPreferences preference = getSharedPreferences("primitive",MODE_PRIVATE);
            SharedPreferences.Editor editor = preference.edit();

            editor.clear();

            editor.apply();

        });

    }
}