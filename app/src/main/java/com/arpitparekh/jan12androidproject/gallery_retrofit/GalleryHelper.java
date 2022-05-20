package com.arpitparekh.jan12androidproject.gallery_retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GalleryHelper {

    static GalleryApi getApiObject(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://wallhaven.cc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GalleryApi api = retrofit.create(GalleryApi.class);

        return api;

    }

}
