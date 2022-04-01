package com.arpitparekh.jan12androidproject.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityMyDialogBinding;
import com.arpitparekh.jan12androidproject.databinding.CustomAlertBinding;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

        binding.btnProgress1.setOnClickListener(view -> {

            ProgressDialog dialog = new ProgressDialog(this);

            dialog.setTitle("Loading....");

            dialog.setMessage("Downloading your files...");

            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            dialog.setButton(Dialog.BUTTON_POSITIVE,"Done",(dialogInterface, i) -> {

                dialogInterface.dismiss();

            });

            dialog.show();


        });

        binding.btnProgress2.setOnClickListener(view -> {

            ProgressDialog dialog = new ProgressDialog(this);

            dialog.setTitle("Downloading...");

            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            dialog.setMax(100);

            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(int i=0;i<=100;i++){

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        dialog.setProgress(i);

                        if(i==dialog.getMax()){

                            dialog.dismiss();
                        }

                    }

                }
            }).start();

            dialog.show();

        });

        binding.btnTimePicker.setOnClickListener(view -> {

            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(this,(timePicker, i, i1) -> {

                String format24 = i+":"+i1;

                SimpleDateFormat hr24 =new SimpleDateFormat("HH:mm");
                SimpleDateFormat hr12 = new SimpleDateFormat("hh:mm a");

                try {

                    Date date24 = hr24.parse(format24);

                    String date12 =  hr12.format(date24);

                    binding.btnTimePicker.setText(date12);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            },hour,min,true);

            dialog.setTitle("Pick Time");
            dialog.setMessage("Time Select karne bhai");

            dialog.setIcon(R.drawable.ic_speed);

            dialog.show();

        });

        binding.btnDatePicker.setOnClickListener(view -> {

            Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(this,(datePicker, i, i1, i2) -> {

                Log.i("date",i+" "+i1+" "+i2);
                binding.btnDatePicker.setText(i2+"/"+(i1+1)+"/"+i);

            },year,month,day);

            dialog.show();

        });

        binding.btnFullScreen.setOnClickListener(view -> {

            binding1 = CustomAlertBinding.inflate(getLayoutInflater());

            Dialog dialog = new Dialog(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
            dialog.setContentView(binding1.getRoot());
            dialog.setTitle("Full Screen Dialog");
            dialog.show();

        });

    }
}