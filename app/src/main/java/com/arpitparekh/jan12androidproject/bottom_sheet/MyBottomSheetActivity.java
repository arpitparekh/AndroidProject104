package com.arpitparekh.jan12androidproject.bottom_sheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.databinding.ActivityMyBottomSheetBinding;

public class MyBottomSheetActivity extends AppCompatActivity {

    private ActivityMyBottomSheetBinding binding;
    private MyBottomSheet bottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyBottomSheetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomSheet = new MyBottomSheet();

        binding.btnOpen.setOnClickListener(view -> {

            bottomSheet.show(getSupportFragmentManager(),"demo");
        });

    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        if(event.getAction()==MotionEvent.ACTION_UP){
//
//            bottomSheet.show(getSupportFragmentManager(),"demo");
//
//        }
//
//        return super.onTouchEvent(event);
//    }
}