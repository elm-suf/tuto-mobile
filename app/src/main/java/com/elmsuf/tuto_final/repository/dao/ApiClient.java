package com.elmsuf.tuto_final.repository.dao;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://10.0.2.2/tutoapp/public/index.php/api/";
//    public static final String BASE_URL = "http://localhost/tutoapp/public/index.php/api/";
    public static Retrofit retrofit = null;


    public static Retrofit getApiClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
