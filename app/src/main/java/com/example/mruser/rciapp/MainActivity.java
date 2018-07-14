package com.example.mruser.rciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Worldpopulation> mAndroidArrayList;
    private DataAdapter mAdapter;
    Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cont=(Button)findViewById(R.id.contBtn);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(i);

            }
        });
//=========================================
        initRecyclerView();
        //================================
        getData();
    }

    private void initRecyclerView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }


    private void getData() {
        Call<PostList> postList=BloggerAPI.getService().getPostList();
        postList.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList androidlist=response.body();
                if(response.isSuccessful()) {
                    mAndroidArrayList = new ArrayList<Worldpopulation>(androidlist.getWorldpopulation());
                    mAdapter = new DataAdapter(mAndroidArrayList,MainActivity.this);
                    mRecyclerView.setAdapter(mAdapter);

                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }
                }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                System.out.println("================================"+call);
                System.out.println("_______________________________"+t);
                Toast.makeText(MainActivity.this, "Error occure", Toast.LENGTH_LONG).show();
            }
        });
    }
}
