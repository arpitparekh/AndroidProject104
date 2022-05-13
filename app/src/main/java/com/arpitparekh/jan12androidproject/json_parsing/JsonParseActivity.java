package com.arpitparekh.jan12androidproject.json_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.arpitparekh.jan12androidproject.databinding.ActivityJsonParseBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonParseActivity extends AppCompatActivity {

    private ActivityJsonParseBinding binding;
    private ArrayList<MyData> list;
    private JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJsonParseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();


        // https://jsonplaceholder.typicode.com/posts

        // https://reqres.in/api/users?page=2

        // OKHttp

        /*

         ArrayAdapter<MyData> adapter = new ArrayAdapter<>(JsonParseActivity.this, android.R.layout.simple_list_item_1,list);
                        binding.listViewJson.setAdapter(adapter);

         */

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://jsonplaceholder.typicode.com/posts")
                        .build();

                Response response = null;
                try {
                    response = client.newCall(request).execute();

                    Log.i("response",response.body().string());

                    String json = response.body().string(); // end of okhttp

                                Log.i("json",json);

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


                } catch (Exception e) {
                    Log.i("exception",e.toString());
                }

            }
        });


    }
}