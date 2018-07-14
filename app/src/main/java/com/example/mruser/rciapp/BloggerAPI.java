package com.example.mruser.rciapp;


import android.content.ClipData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class BloggerAPI {
    private static final String key="tutorial/jsonparsetutorial.txt";
    private static final String url="http://www.androidbegin.com/";

    public static PostService postService=null;

    public static PostService getService() {

        if(postService==null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            postService=retrofit.create(PostService.class);
        }
        return postService;

    }

    public interface PostService {
        @GET(key)
        Call<PostList> getPostList();
        }

}
