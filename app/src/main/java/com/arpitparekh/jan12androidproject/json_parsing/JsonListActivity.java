package com.arpitparekh.jan12androidproject.json_parsing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.arpitparekh.jan12androidproject.databinding.ActivityJsonList2Binding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonListActivity extends AppCompatActivity {

    private ActivityJsonList2Binding binding;
    private ArrayList<MyData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJsonList2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {


                JSONArray jsonArray = null;
                try {

                    String json = response.body().string();

                    jsonArray = new JSONArray(json);

                    for(int i=0;i< jsonArray.length();i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String title = jsonObject.getString("title");
                        String body = jsonObject.getString("body");

                        MyData myData = new MyData(title,body);


                        Log.i("myData",myData.toString());
                        list.add(myData);
                    }

                Log.i("list",list.toString());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ArrayAdapter<MyData> adapter = new ArrayAdapter<>(JsonListActivity.this, android.R.layout.simple_list_item_1,list);
                            binding.listViewJson.setAdapter(adapter);
                        }
                    });

                } catch (Exception e) {
                   Log.i("exception",e.toString());
                }

            }
        });

    }
}