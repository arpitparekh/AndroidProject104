package com.arpitparekh.jan12androidproject.fragment_new_way;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import com.arpitparekh.jan12androidproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.arpitparekh.jan12androidproject.databinding.ActivityAnotherHolderBinding;

public class AnotherHolderActivity extends AppCompatActivity {

    private ActivityAnotherHolderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnotherHolderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn1.setOnClickListener(view -> {

            // prev
            Navigation.findNavController(this,R.id.fcv_another_holder)
                    .navigate(R.id.firstFragment2);

        });

        binding.btn2.setOnClickListener(view -> {
            // next

            if(!checkCurrentFragment("fragment_second")){
                Navigation.findNavController(this,R.id.fcv_another_holder)
                        .navigate(R.id.secondFragment);
            }
        });

    }

    @Override
    public void onBackPressed() {


        if(checkCurrentFragment("fragment_first")){

            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            startActivity(i);

//            super.onBackPressed();

        }else if(checkCurrentFragment("fragment_second")){

            Navigation.findNavController(this,R.id.fcv_another_holder)
                    .navigate(R.id.firstFragment2);

        }


//
    }

    boolean checkCurrentFragment(String name){

        return Navigation.findNavController(this,R.id.fcv_another_holder).getCurrentDestination().getLabel().toString().equals(name);

    }
}