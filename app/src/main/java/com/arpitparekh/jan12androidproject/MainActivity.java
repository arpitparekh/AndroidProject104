package com.arpitparekh.jan12androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("life","create");

        // View

        Button b = findViewById(R.id.btnGo);

        FloatingActionButton fab = findViewById(R.id.fab);

        ImageView iv = findViewById(R.id.iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"This is snakBar",Snackbar.LENGTH_SHORT).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "This is Another Toast", Toast.LENGTH_SHORT).show();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Le a Toast",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life","start");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life","resume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life","pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life","stop");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("life","restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life","destroy");

    }
}