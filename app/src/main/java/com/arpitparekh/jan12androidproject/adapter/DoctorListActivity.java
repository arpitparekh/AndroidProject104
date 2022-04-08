package com.arpitparekh.jan12androidproject.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityDoctorListBinding;
import com.arpitparekh.jan12androidproject.databinding.UpdateDoctorLayoutBinding;

import java.util.ArrayList;

public class DoctorListActivity extends AppCompatActivity {

    private ActivityDoctorListBinding binding;
    private UpdateDoctorLayoutBinding binding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Doctor> list = new ArrayList<>();

        // Adapter

        // used to display large chunk of list data into layout

        // ArrayAdapter  (used to display data into listView)
        // SimpleAdapter
        // RecyclerView Adapter

        ArrayAdapter<Doctor> adapter = new ArrayAdapter<>(this, R.layout.list_item,list);

        binding.listViewDoctors.setAdapter(adapter);


        binding.btnAdd.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String address = binding.edtAddress.getText().toString();

            Doctor d = new Doctor(name,address);

            list.add(d);

            adapter.notifyDataSetChanged();

            binding.edtName.setText("");
            binding.edtAddress.setText("");

        });

        binding.listViewDoctors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                binding1 = UpdateDoctorLayoutBinding.inflate(getLayoutInflater());

                Doctor d = list.get(pos);

                binding1.edtNameDialog.setText(d.name);
                binding1.edtAddressDialog.setText(d.address);

                new AlertDialog.Builder(DoctorListActivity.this)
                        .setTitle("Choose One")
                        .setPositiveButton("Update",(dialogInterface, i) -> {

                            // update

                            new AlertDialog.Builder(DoctorListActivity.this)
                                    .setTitle("Update Doctor")
                                    .setView(binding1.getRoot())
                                    .setPositiveButton("Update",(dialogInterface1, i1) -> {

                                        String newName = binding1.edtNameDialog.getText().toString();
                                        String newAddress = binding1.edtAddressDialog.getText().toString();

                                        Doctor newD = new Doctor(newName,newAddress);

                                        list.set(pos,newD);

                                        adapter.notifyDataSetChanged();


                                    })
                                    .setNeutralButton("Cancel",(dialogInterface1, i1) -> {

                                        dialogInterface1.dismiss();

                                    }).create().show();


                        }).setNegativeButton("Delete",(dialogInterface, i) -> {

                            // delete

                            list.remove(d);

                            adapter.notifyDataSetChanged();

                        }).create().show();


            }
        });

    }
}