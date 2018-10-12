package com.example.texnobaku.tatikretrofitdatabasetask2.controller;

import com.example.texnobaku.tatikretrofitdatabasetask2.model.callback.FlowerService;
import com.example.texnobaku.tatikretrofitdatabasetask2.model.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestManager {


    private FlowerService mFlowerService;


    public FlowerService getFlowerService () {
        if (mFlowerService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mFlowerService = retrofit.create(FlowerService.class);
        }
        return mFlowerService;

    }
}
