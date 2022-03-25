package com.arpitparekh.jan12androidproject.designing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import com.arpitparekh.jan12androidproject.databinding.ActivitySeekbarBinding;

public class SeekbarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ActivitySeekbarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeekbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivColorCode.setBackgroundColor(Color.BLACK);

        binding.sbRed.setOnSeekBarChangeListener(this);
        binding.sbGreen.setOnSeekBarChangeListener(this);
        binding.sbBlue.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int red = binding.sbRed.getProgress();
        int green = binding.sbGreen.getProgress();
        int blue = binding.sbBlue.getProgress();

        binding.ivColorCode.setBackgroundColor(Color.rgb(red,green,blue));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}