package com.arpitparekh.jan12androidproject.activity_result;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.databinding.ActivityMyResultBinding;

public class MyResultActivity extends AppCompatActivity {

    private ActivityMyResultBinding binding;
    ActivityResultLauncher<String> permission;
    private int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // Activity Result Launcher

        ActivityResultLauncher<String> gallery = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                // Uri
                // unified result identifier

                binding.ivPhoto.setImageURI(result);
            }
        });

        permission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {

                if(result){

                    Toast.makeText(MyResultActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                }else{

                    showDialog();

                }

            }
        });
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){

            permission.launch(Manifest.permission.READ_CONTACTS);

        }

        binding.ivPhoto.setOnClickListener(view -> {

            gallery.launch("image/*");

        });

        binding.btnPermission.setOnClickListener(view -> {

            permission.launch(Manifest.permission.READ_CONTACTS);

        });

    }

    private void showDialog() {

        counter++;

        new AlertDialog.Builder(this)
                .setTitle("Please Allow the Permission Please")
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(counter>1){

                            Intent i2 = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            i2.setData(Uri.fromParts("package",getPackageName(),null));
                            startActivity(i2);

                        }else{

                            permission.launch(Manifest.permission.READ_CONTACTS);

                        }

                    }
                })
                .setCancelable(false)
                .create().show();

    }
}