package com.arpitparekh.jan12androidproject.offline_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityMyInternalBinding;
import com.arpitparekh.jan12androidproject.designing.DesignActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyInternalActivity extends AppCompatActivity {

    private ActivityMyInternalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyInternalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSendInternal.setOnClickListener(view -> {

            String data = binding.edtInternal.getText().toString();

            try {

                FileOutputStream fos = openFileOutput("demo.txt",MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();
                Toast.makeText(this, "Data Write Successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        binding.btnReceiverInternal.setOnClickListener(view -> {

            try {

                FileInputStream fis = openFileInput("demo.txt");
                byte arr[] = new byte[fis.available()];
                fis.read(arr);

                String data = new String(arr);

                binding.tvReceiver.setText(data);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        Bitmap map = BitmapFactory.decodeResource(getResources(), R.drawable.banner);
//        Intent i = new Intent(this, DesignActivity.class);
//        i.putExtra("bit",map);
        binding.ivRandom.setImageBitmap(map);
//        binding.ivRandom.setImageResource();

    }
}