package com.arpitparekh.jan12androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.arpitparekh.jan12androidproject.cordinator_layout.MyCoActivity;
import com.arpitparekh.jan12androidproject.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    Thread.sleep(5000);
                }catch (Exception e){

                    Log.i("ex",e.toString());
                }


                Intent i = new Intent(SplashScreenActivity.this, MyCoActivity.class);
                startActivity(i);
                finish();  // do not come back to this activity

            }
        }).start();
    }
}