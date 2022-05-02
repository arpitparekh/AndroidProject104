package com.arpitparekh.jan12androidproject.storage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.databinding.ActivityStorageBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class StorageActivity extends AppCompatActivity {

    private ActivityStorageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSendInternal.setOnClickListener(view -> {

            String data = binding.edtData.getText().toString();

            try {

                FileOutputStream fos = openFileOutput("demo.txt",MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "Data Send Successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        binding.btnFetchInternal.setOnClickListener(view -> {

            try {

                FileInputStream fis = openFileInput("demo.txt");

                byte[] arr = new byte[fis.available()];

                fis.read(arr);

                String data = new String(arr);

                binding.tvInternal.setText(data);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        binding.btnSendExternal.setOnClickListener(view -> {

            checkPermission();

            String data = binding.edtData.getText().toString();

            File externalFolder = Environment.getExternalStorageDirectory();

            File file = new File(externalFolder,"hello.txt");

            try {

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "Data Write Successfully in External", Toast.LENGTH_SHORT).show();


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        binding.btnFetchExternal.setOnClickListener(view -> {

            checkPermission();

            File externalFolder = Environment.getExternalStorageDirectory();

            File file = new File(externalFolder,"hello.txt");

            try {
                FileInputStream fis = new FileInputStream(file);
                byte arr[] = new byte[fis.available()];
                fis.read(arr);
                String data = new String(arr);
                binding.tvExternal.setText(data);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }


    void checkPermission(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){

            if(!Environment.isExternalStorageManager()){

                Intent i = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                i.setData(Uri.fromParts("package",getPackageName(),null));
                startActivity(i);
            }

        }else{

            if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},101);

            }
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();

            }else{

                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();

            }

        }


    }
}