package com.umang_rathod.backend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/2/comments")
    Call<List<Comment>> getComments();
}
