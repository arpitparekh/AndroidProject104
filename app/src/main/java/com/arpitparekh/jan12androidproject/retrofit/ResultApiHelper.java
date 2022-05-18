package com.arpitparekh.jan12androidproject.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultApiHelper {

    public static ResultApi getApiObject(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cricket-live-data.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ResultApi.class);

    }

}
