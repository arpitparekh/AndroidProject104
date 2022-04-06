package com.arpitparekh.jan12androidproject.radioButton_textChange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityRadioTextBinding;

public class RadioTextActivity extends AppCompatActivity {

    private ActivityRadioTextBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRadioTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rgVehicle.setOnCheckedChangeListener((radioGroup, i) -> {

            switch (radioGroup.getCheckedRadioButtonId()){

                case R.id.rbCar:
                    Toast.makeText(this, "Car", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rbFlight:
                    Toast.makeText(this, "Flight", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rbBike:
                    Toast.makeText(this, "Bike", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rbRickShaw:
                    Toast.makeText(this, "Rickshaw", Toast.LENGTH_SHORT).show();
                    break;

            }

        });

    }
}