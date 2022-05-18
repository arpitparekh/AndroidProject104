package com.arpitparekh.jan12androidproject.retrofit;

import com.arpitparekh.jan12androidproject.retrofit.classes.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ResultApi {

    @GET("results")
    @Headers({"X-RapidAPI-Host: cricket-live-data.p.rapidapi.com",
    "X-RapidAPI-Key: 6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077"})
    Call<Result> getResult();

}
