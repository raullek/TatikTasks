package com.example.texnobaku.tatikretrofitdatabasetask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.texnobaku.tatikretrofitdatabasetask2.controller.RestManager;
import com.example.texnobaku.tatikretrofitdatabasetask2.model.Flower;
import com.example.texnobaku.tatikretrofitdatabasetask2.model.adapter.FlowerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private FlowerAdapter mFlowerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();

        mManager = new RestManager();
        Call<List<Flower>>listCall = mManager.getFlowerService().getAllFlowers();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {

                if (response.isSuccessful()){
                    List<Flower> flowerList = response.body();

                    for (int i= 0 ; i<flowerList.size(); i++) {

                        Flower flower = flowerList.get(i);
                        mFlowerAdapter.addFlower(flower);


                    }


                }
                else {
                     int sc = response.code();
                     switch (sc){

                     }
                }

            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });

        listCall.cancel();


    }

    private void configViews () {
            mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
            mFlowerAdapter = new FlowerAdapter();

            mRecyclerView.setAdapter(mFlowerAdapter);
    }
}
