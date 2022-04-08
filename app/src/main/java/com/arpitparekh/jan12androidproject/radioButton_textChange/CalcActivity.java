package com.arpitparekh.jan12androidproject.radioButton_textChange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RadioGroup;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityCalcBinding;

public class CalcActivity extends AppCompatActivity implements TextWatcher {

    private ActivityCalcBinding binding;
    private String math= "sum";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.rbSum.setChecked(true);

        binding.edtNum1.addTextChangedListener(this);
        binding.edtNum2.addTextChangedListener(this);

        binding.rgMath.setOnCheckedChangeListener((radioGroup, i) -> {

            String number1 = binding.edtNum1.getText().toString();
            String number2 = binding.edtNum2.getText().toString();

            float num1 = Float.parseFloat(number1);
            float num2 = Float.parseFloat(number2);

            switch(radioGroup.getCheckedRadioButtonId()){
                case R.id.rbSum:
                    binding.tvMath.setText(String.valueOf(num1+num2));
                    math = "sum";
                    break;
                case R.id.rbSub:
                    math = "sub";
                    binding.tvMath.setText(String.valueOf(num1-num2));
                    break;
                case R.id.rbMul:
                    math = "mul";
                    binding.tvMath.setText(String.valueOf(num1*num2));
                    break;
                case R.id.rbDiv:
                    math = "div";
                    binding.tvMath.setText(String.valueOf(num1/num2));
                    break;
            }

        });

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        String number1 = binding.edtNum1.getText().toString();
        String number2 = binding.edtNum2.getText().toString();

        if(number1.length()>6){
            binding.edtNum1.setError("Max size is 6");
        }
        if(number2.length()>6){
            binding.edtNum2.setError("Max size is 6");
        }

        if(number1.isEmpty() || number2.isEmpty() || number1.length()>6 || number2.length()>6 ){

            binding.tvMath.setText("Something is wrong");

        } else{

            float num1 = Float.parseFloat(number1);
            float num2 = Float.parseFloat(number2);

            switch (math){

                case "sum":
                    binding.tvMath.setText(String.valueOf(num1+num2));
                    break;
                case "sub":
                    binding.tvMath.setText(String.valueOf(num1-num2));
                    break;
                case "mul":
                    binding.tvMath.setText(String.valueOf(num1*num2));
                    break;
                case "div":
                    binding.tvMath.setText(String.valueOf(num1/num2));
                    break;
            }

        }

        // string -> int //  Integer.parse(string)
        // int -> string //  String.ValueOf(int)

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}