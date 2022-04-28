package com.arpitparekh.jan12androidproject.expnadable_toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.arpitparekh.jan12androidproject.databinding.ActivityExpandableBinding;

import java.util.ArrayList;

public class ExpandableActivity extends AppCompatActivity {

    private ActivityExpandableBinding binding;
    ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpandableBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
//        list.add("sdfdsf");
//        list.add("sdfdsf");
//        list.add("sdfdsf");list.add("sdfdsf");list.add("sdfdsf");list.add("sdfdsf");
//        list.add("sdfdsf");list.add("sdfdsf");list.add("sdfdsf");list.add("sdfdsf");
//        list.add("sdfdsf");list.add("sdfdsf");list.add("sdfdsf");

//        ArrayAdapter<String>  adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
//
//        binding.listView.setAdapter(adapter);
//

    }
}