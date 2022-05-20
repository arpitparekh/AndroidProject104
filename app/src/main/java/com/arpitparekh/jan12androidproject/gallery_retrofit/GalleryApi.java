package com.arpitparekh.jan12androidproject.gallery_retrofit;

import com.arpitparekh.jan12androidproject.gallery_retrofit.pojo.Gallery;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GalleryApi {

    @GET("api/v1/search")
    Call<Gallery> getImages(@Query("apikey")String key,@Query("q")String xyz,@Query("categories")int category);

}
