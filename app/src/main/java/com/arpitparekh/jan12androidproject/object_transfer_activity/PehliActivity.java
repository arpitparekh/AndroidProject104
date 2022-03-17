package com.arpitparekh.jan12androidproject.object_transfer_activity;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.jan12androidproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PehliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pehli);

        Button b = findViewById(R.id.btnObject);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student s = new Student("pradip","kalupur");

                Intent i = new Intent(PehliActivity.this,DusriActivity.class);
                i.putExtra("data",s);

                // serialize

                startActivity(i);

            }
        });


    }
}