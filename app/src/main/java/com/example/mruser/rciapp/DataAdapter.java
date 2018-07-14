package com.example.mruser.rciapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.service.autofill.FieldClassification;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    String img_uri;
    @SerializedName("worldpopulation")
    @Expose
    private ArrayList<Worldpopulation> mAndroidList;
    public DataAdapter(ArrayList<Worldpopulation> androidList, Context context) {
        this.mAndroidList = androidList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        img_uri=mAndroidList.get(position).getFlag().toString();
        holder.rank.setText("Rank:"+mAndroidList.get(position).getRank().toString());
        holder.country.setText("Country:"+mAndroidList.get(position).getCountry().toString());
        holder.population.setText("Popolation:"+mAndroidList.get(position).getPopulation().toString());
       Glide.with(context).load(img_uri).into(holder.ivv);

    }

    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView rank,country,population;
             ImageView ivv;
        public ViewHolder(View view) {
            super(view);
            ivv=(ImageView)view.findViewById(R.id.imageRV);
            rank = (TextView)view.findViewById(R.id.rank);
            country = (TextView)view.findViewById(R.id.country);
            population = (TextView)view.findViewById(R.id.population);
            ivv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Intent i = new Intent(context,Main2Activity.class);
                    Intent fullScreenIntent = new Intent(context, Main2Activity.class);
                    fullScreenIntent.putExtra("imgK",img_uri);
                    context.startActivity(fullScreenIntent);
                }
            });

        }

    }
}
