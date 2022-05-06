package com.arpitparekh.jan12androidproject.room_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.arpitparekh.jan12androidproject.databinding.ActivityEmpListBinding;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpListBinding binding;
    private EmpDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityEmpListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dao =  DatabaseHelper.getDatabaseObject(this).getDao();

        binding.btnStoreEmp.setOnClickListener(view -> {

            String name = binding.edtEmpName.getText().toString();
            String address = binding.edtEmpAddress.getText().toString();

            Emp e = new Emp(name,address);

            dao.insertEmp(e);

        });

    }
}