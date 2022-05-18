package com.arpitparekh.jan12androidproject.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.arpitparekh.jan12androidproject.databinding.ActivityMatchResultBinding;
import com.arpitparekh.jan12androidproject.retrofit.classes.Result;
import com.arpitparekh.jan12androidproject.retrofit.classes.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchResultActivity extends AppCompatActivity {

    private ActivityMatchResultBinding binding;
    private List<ResultsItem> results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMatchResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        results = new ArrayList<>();

        Call<Result> call =  ResultApiHelper.getApiObject().getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result =  response.body();

                Log.i("result",result.toString());

                results = result.getResults();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        ArrayAdapter<ResultsItem>adapter = new ArrayAdapter<>(MatchResultActivity.this, android.R.layout.simple_list_item_1,results);

                        binding.listViewMatchResult.setAdapter(adapter);
                    }
                });
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("result",t.toString());
            }
        });


    }
}