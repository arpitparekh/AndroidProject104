package com.arpitparekh.jan12androidproject.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.arpitparekh.jan12androidproject.databinding.FullScreenDialogBinding;

public class MyDialog extends DialogFragment {

    private FullScreenDialogBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FullScreenDialogBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}
