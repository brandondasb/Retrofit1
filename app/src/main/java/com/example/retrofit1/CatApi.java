package com.example.retrofit1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatApi {
    @GET("facts")
    Call<GsonCatFacts> getCatsFacts();
}
