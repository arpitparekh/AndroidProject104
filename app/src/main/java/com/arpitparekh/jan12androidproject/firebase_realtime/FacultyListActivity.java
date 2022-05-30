package com.arpitparekh.jan12androidproject.firebase_realtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.databinding.ActivityFacultyListBinding;
import com.arpitparekh.jan12androidproject.databinding.FacultyUpdateDialogBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FacultyListActivity extends AppCompatActivity {

    private ActivityFacultyListBinding binding;
    private FacultyUpdateDialogBinding binding1;
    private DatabaseReference ref;
    private ArrayList<Faculty> list;
    private ArrayList<String> keyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFacultyListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        keyList = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("faculty").child("facultyData");

//        ref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();
                keyList.clear();

                for(DataSnapshot childSnap : snapshot.getChildren()){

                    Faculty faculty =  childSnap.getValue(Faculty.class);
                    String key = childSnap.getKey();   // get each key

                    list.add(faculty);
                    keyList.add(key);

                }

                ArrayAdapter<Faculty> adapter = new ArrayAdapter<>(FacultyListActivity.this,
                        android.R.layout.simple_list_item_1,list);
                binding.listViewFaculty.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.listViewFaculty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Faculty faculty = list.get(pos);  // clicked faculty object
                String key = keyList.get(pos);

                binding1 = FacultyUpdateDialogBinding.inflate(getLayoutInflater());

                binding1.edtAddressUpdate.setText(faculty.address);
                binding1.edtNameUpdate.setText(faculty.name);
                binding1.edtSalaryUpdate.setText(String.valueOf(faculty.salary));


                new AlertDialog.Builder(FacultyListActivity.this)
                        .setTitle("Choose One")
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                new AlertDialog.Builder(FacultyListActivity.this)
                                        .setTitle("Update")
                                        .setView(binding1.getRoot())
                                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                                String name = binding1.edtNameUpdate.getText().toString();
                                                String salary = binding1.edtSalaryUpdate.getText().toString();
                                                String address = binding1.edtAddressUpdate.getText().toString();

                                                Faculty updatedFaculty = new Faculty(name,Float.parseFloat(salary),address);

                                                //////////////////////////////////////////////
                                                ref.child(key).setValue(updatedFaculty);

                                            }
                                        }).create().show();

                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                ///////////////////////////////////////////
                                ref.child(key).removeValue();
                            }
                        }).create().show();

            }
        });

        binding.btnAddData.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String salary = binding.edtSalary.getText().toString();
            String address = binding.edtAddress.getText().toString();

            Faculty faculty = new Faculty(name,Float.parseFloat(salary),address);

            ref.push().setValue(faculty).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(FacultyListActivity.this, "Data added", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(FacultyListActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });


        });
    }
}