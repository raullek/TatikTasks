package com.example.texnobaku.tatikretrofitdatabasetask2.model.callback;

import com.example.texnobaku.tatikretrofitdatabasetask2.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerService {


    @GET("/feeds/flowers.json")
    Call<List<Flower>>getAllFlowers();

}
