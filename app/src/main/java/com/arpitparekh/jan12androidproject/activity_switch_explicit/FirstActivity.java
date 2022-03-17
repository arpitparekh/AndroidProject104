package com.arpitparekh.jan12androidproject.activity_switch_explicit;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.jan12androidproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        setTitle("First");  // action bar title

        getSupportActionBar().hide();  // hide actionBar

        Button b = findViewById(R.id.btnNext);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Intent

                Intent i = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(i);
                finish();

                // context
                // destination class


            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("log","destroy");
    }
}