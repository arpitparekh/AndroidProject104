package com.arpitparekh.jan12androidproject.room_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.arpitparekh.jan12androidproject.databinding.ActivityEmpListBinding;
import com.arpitparekh.jan12androidproject.databinding.RoomUpdateDialogBinding;

import java.util.ArrayList;
import java.util.List;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpListBinding binding;
    private RoomUpdateDialogBinding dialogBinding;
    private EmpDao dao;
    private List<Emp> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityEmpListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        dao =  DatabaseHelper.getDatabaseObject(this).getDao();

        showEmpData();

        binding.listViewEmp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                dialogBinding = RoomUpdateDialogBinding.inflate(getLayoutInflater());

                Emp e = list.get(position);

                dialogBinding.dialogName.setText(e.name);
                dialogBinding.dialogAddress.setText(e.address);

                new AlertDialog.Builder(EmpListActivity.this)
                        .setTitle("Choose One")
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                                ///////////////////////////////////

                                new AlertDialog.Builder(EmpListActivity.this)
                                        .setTitle("Update")
                                        .setView(dialogBinding.getRoot())
                                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                                String name = dialogBinding.dialogName.getText().toString();
                                                String address = dialogBinding.dialogAddress.getText().toString();

                                                e.name = name;
                                                e.address = address;

                                                dao.updateEmp(e);

                                                showEmpData();


                                            }
                                        }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                }).create().show();

                                ///////////////////////////////

                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dao.deleteEmp(e);

                        showEmpData();

                    }
                }).create().show();

            }
        });

        binding.btnStoreEmp.setOnClickListener(view -> {
            String name = binding.edtEmpName.getText().toString();
            String address = binding.edtEmpAddress.getText().toString();
            Emp e = new Emp(name,address);
            dao.insertEmp(e);

            showEmpData();

        });
    }

    private void showEmpData() {

        list =  dao.showData();

        ArrayAdapter<Emp> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listViewEmp.setAdapter(adapter);

    }
}