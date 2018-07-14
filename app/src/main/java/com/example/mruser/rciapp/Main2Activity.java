package com.example.mruser.rciapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Main2Activity extends AppCompatActivity {
ImageView fsiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    fsiv=(ImageView) findViewById(R.id.imgf);
savedInstanceState=getIntent().getExtras();
String img=savedInstanceState.getString("imgK");
        Glide.with(this)
                .load(img)
                .into(fsiv);


    }

}
