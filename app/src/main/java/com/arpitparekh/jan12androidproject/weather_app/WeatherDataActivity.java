package com.arpitparekh.jan12androidproject.weather_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.arpitparekh.jan12androidproject.databinding.ActivityWeatherDataBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherDataActivity extends AppCompatActivity {

    private ActivityWeatherDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSearch.setOnClickListener(view -> {


            String city = binding.edtCity.getText().toString();

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://community-open-weather-map.p.rapidapi.com/weather?q="+city+"&units=metric")
                    .addHeader("X-RapidAPI-Host", "community-open-weather-map.p.rapidapi.com")
                    .addHeader("X-RapidAPI-Key", "6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077")
                    .build();

            Call call =  client.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {

                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                    Log.i("response",response.body().string());

                    String json = response.body().string();

                    try {

                        JSONObject object = new JSONObject(json);

                        String name = object.getString("name");

                        JSONObject mainObject = object.getJSONObject("main");

                        Double temp = mainObject.getDouble("temp");
                        Double humidity = mainObject.getDouble("humidity");

                       JSONObject windObject = object.getJSONObject("wind");

                       Double wind = windObject.getDouble("speed");

                       Log.i("response",temp+"\n"+humidity+"\n"+name+"\n"+wind);

                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             binding.tvName.setText(name);
                             binding.tvHumidity.setText(String.valueOf(humidity));
                             binding.tvTemp.setText(String.valueOf(temp));
                             binding.tvWind.setText(String.valueOf(wind));
                         }
                     });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        });


    }
}