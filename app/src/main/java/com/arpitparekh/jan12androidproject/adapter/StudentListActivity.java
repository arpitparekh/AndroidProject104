package com.arpitparekh.jan12androidproject.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityStudentListBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentListActivity extends AppCompatActivity {

    private ActivityStudentListBinding binding;
    private ArrayList<HashMap<String,String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        HashMap<String,String> map = new HashMap<>();

        map.put("Country","India");
        map.put("Capital","Delhi");

        list.add(map);

        HashMap<String,String> map2 = new HashMap<>();

        map2.put("Country","Pakistan");
        map2.put("Capital","Islamabad");

        list.add(map2);

        HashMap<String,String> map3 = new HashMap<>();

        map3.put("Country","China");
        map3.put("Capital","Shanghai");

        list.add(map3);

        String[] from = {"Country","Capital"};
        int[] to = {R.id.tvCountry,R.id.tvCapital};


        // Simple Adapter

        SimpleAdapter adapter = new SimpleAdapter(this,list, R.layout.custom_simple_layout,from,to);

        binding.listViewSimpleAdapter.setAdapter(adapter);

    }
}