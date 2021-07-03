package com.example.mygraduationprojectamit.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private RetrofitClient(){}
    private static Retrofit retrofit;
    public static CategoryApi getApi() {
        if (retrofit == null) {
            retrofit=new Retrofit.Builder().baseUrl("https://retail.amit-learning.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()  )
                    .build();

        }
        return retrofit.create(CategoryApi.class);
    }



}
