package com.arpitparekh.jan12androidproject.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityMyDialogBinding;
import com.arpitparekh.jan12androidproject.databinding.CustomAlertBinding;
import com.google.android.material.snackbar.Snackbar;

public class MyDialogActivity extends AppCompatActivity {

    private ActivityMyDialogBinding binding;
    private CustomAlertBinding binding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAlert1.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("This is Title");

            builder.setMessage("This is Message");

            builder.setIcon(R.drawable.ic_speed);

            builder.setCancelable(false);
            
            builder.setPositiveButton("Toast", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Toast.makeText(MyDialogActivity.this, "Toast From dialog", Toast.LENGTH_SHORT).show();
                }
            });
            
            builder.setNegativeButton("No",(dialogInterface, i) -> {

                Snackbar.make(binding.getRoot(),"Snackbar from dialog",Snackbar.LENGTH_SHORT).show();
                
            });
            
            builder.setNeutralButton("Cancel",(dialogInterface, i) -> {
                
                dialogInterface.dismiss();
                
            });

            builder.show();


        });


        binding.btnAlert2.setOnClickListener(view -> {

            binding1 = CustomAlertBinding.inflate(getLayoutInflater());

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Custom Alert Dialog");

            builder.setView(binding1.getRoot());

            builder.setPositiveButton("Ok",(dialogInterface, i) -> {

                AlertDialog.Builder childBuilder = new AlertDialog.Builder(this);

                childBuilder.setPositiveButton("Ok",(dialogInterface1, i1) -> {

                    String text = binding1.edtDialog.getText().toString();

                    binding.tvCustom.setText(text);

                });

                childBuilder.show();

            });

            builder.show();

        });

    }
}