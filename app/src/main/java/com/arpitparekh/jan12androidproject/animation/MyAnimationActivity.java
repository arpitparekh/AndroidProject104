package com.arpitparekh.jan12androidproject.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityMyAnimationBinding;

public class MyAnimationActivity extends AppCompatActivity {

    private ActivityMyAnimationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAnimationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSlide.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.slide_animation);
            binding.ivAnimation.startAnimation(animation);

        });
        binding.btnClear.setOnClickListener(view -> {

            binding.ivAnimation.clearAnimation();

        });

        binding.btnZoom.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.zoom_animation);
            binding.ivAnimation.startAnimation(animation);

        });

        binding.btnFade.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.fade_animation);
            binding.ivAnimation.startAnimation(animation);

        });

        binding.btnRotate.setOnClickListener(view -> {

            Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
            binding.ivAnimation.startAnimation(animation);

        });

    }
}