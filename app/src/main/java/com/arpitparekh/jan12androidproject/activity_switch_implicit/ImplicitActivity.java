package com.arpitparekh.jan12androidproject.activity_switch_implicit;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.jan12androidproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class ImplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        Button b = findViewById(R.id.btnContact);
        Button b1 = findViewById(R.id.btnCamera);
        Button b2 = findViewById(R.id.btnHome);
        Button b3 = findViewById(R.id.btnSettings);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_MAIN);   // intent flags
                i.addCategory(Intent.CATEGORY_APP_CONTACTS);
                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                startActivity(i);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Settings.ACTION_DATA_USAGE_SETTINGS);
                startActivity(i);

            }
        });


    }
}