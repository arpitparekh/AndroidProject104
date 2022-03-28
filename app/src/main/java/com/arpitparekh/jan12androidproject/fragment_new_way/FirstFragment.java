package com.arpitparekh.jan12androidproject.fragment_new_way;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.animationView.setVisibility(View.GONE);

        binding.btnGoNext.setOnClickListener(view1 -> {

            Navigation.findNavController(getView())
                    .navigate(R.id.firstToSecond);

        });

        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){

                    binding.animationView.setVisibility(View.VISIBLE);

                }else{

                    binding.animationView.setVisibility(View.GONE);
                }

            }
        });

    }
}