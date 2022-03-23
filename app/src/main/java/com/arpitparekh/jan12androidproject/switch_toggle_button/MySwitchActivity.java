package com.arpitparekh.jan12androidproject.switch_toggle_button;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityMySwitchBinding;

public class MySwitchActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ActivityMySwitchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMySwitchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getRoot().setBackgroundColor(Color.rgb(35,124,195));

        binding.imageView4.setVisibility(View.GONE);

        binding.checkbox.setOnCheckedChangeListener(this);
        binding.switch1.setOnCheckedChangeListener(this);
        binding.tb.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(b){

            if(compoundButton== binding.checkbox){

//                binding.getRoot().setBackgroundColor(Color.rgb(52,42,255));

                binding.getRoot().setBackgroundResource(R.drawable.banner);
            }else{
//                binding.getRoot().setBackgroundColor(Color.rgb(56,142,70));

                binding.getRoot().setBackgroundResource(R.drawable.banner);
            }

            binding.imageView4.setVisibility(View.VISIBLE);


        }else{

            binding.getRoot().setBackgroundColor(Color.rgb(35,124,195));

            binding.imageView4.setVisibility(View.GONE);
        }



    }
}