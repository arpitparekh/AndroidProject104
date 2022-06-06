package com.arpitparekh.jan12androidproject.internal_external_storage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.databinding.ActivityMyInternal2Binding;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.Permission;

public class MyInternalExternalActivity extends AppCompatActivity {

    private ActivityMyInternal2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyInternal2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnInternalWrite.setOnClickListener(view -> {

            String data = binding.edtStorage.getText().toString();

            try {

                FileOutputStream fos = openFileOutput("interview.txt",MODE_PRIVATE);

                fos.write(data.getBytes());

                fos.close();

                Snackbar.make(binding.getRoot(),"File Write Successfully",Snackbar.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        binding.btnInternalRead.setOnClickListener(view -> {
            try {
                FileInputStream fis = openFileInput("interview.txt");

                byte arr[] = new byte[fis.available()];

                fis.read(arr);

                String result = new String(arr);

                binding.tvInternal.setText(result);


            } catch (Exception e) {
                e.printStackTrace();
            }

        });


        binding.btnExternalWrite.setOnClickListener(view -> {

            String data = binding.edtStorage.getText().toString();

            askForPermission();

            File sdcardFolder = Environment.getExternalStorageDirectory();

            File folder = new File(sdcardFolder,"myFolder");

            folder.mkdir();

            File file = new File(folder,"interview.txt");

            try {

                FileOutputStream fos = new FileOutputStream(file);

                fos.write(data.getBytes());

                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }


        });



    }


    private void askForPermission(){

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},101);

        }else{

            Toast.makeText(this, "Permission Already Given", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();

            }else{

                Toast.makeText(this, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            }

        }

    }
}