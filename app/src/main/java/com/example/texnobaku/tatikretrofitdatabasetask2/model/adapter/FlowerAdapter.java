package com.example.texnobaku.tatikretrofitdatabasetask2.model.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.texnobaku.tatikretrofitdatabasetask2.R;
import com.example.texnobaku.tatikretrofitdatabasetask2.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {
    private static final String TAG = FlowerAdapter.class.getSimpleName();

    private List<Flower> mFlowers ;

    public FlowerAdapter () {
        mFlowers = new ArrayList<>();

    }




    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Flower currFlower = mFlowers.get(position);
        holder.mName.setText(currFlower.getName());
        holder.mPrice.setText(Double.toString(currFlower.getPrice()));

        Picasso.with(holder.itemView.getContext()).load(currFlower.getPhoto()).into(holder.mPhoto);

    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public void addFlower(Flower flower) {

        Log.d(TAG, flower.getPhoto());
        mFlowers.add(flower);
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
        private ImageView mPhoto;
        private TextView mName, mPrice;


        public Holder(View itemView) {
            super(itemView);
            mPhoto= itemView.findViewById(R.id.flowerPhoto);
            mName = itemView.findViewById(R.id.flowerName);
            mPrice = itemView.findViewById(R.id.flowerPrice);

        }
    }
}
