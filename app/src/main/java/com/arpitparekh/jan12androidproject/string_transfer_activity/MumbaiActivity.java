package com.arpitparekh.jan12androidproject.string_transfer_activity;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.jan12androidproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MumbaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai);

        EditText e = findViewById(R.id.edtSomething);
        Button b = findViewById(R.id.btnSend);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = e.getText().toString();
                
                if(str.isEmpty()){

//                    Toast.makeText(MumbaiActivity.this, "Fill the data", Toast.LENGTH_SHORT).show();

                    e.setError("Fill the data");

                    
                }else{

                    Intent i = new Intent(MumbaiActivity.this,GoaActivity.class);
                    i.putExtra("data",str);
                    startActivity(i);

                }



            }
        });

    }
}