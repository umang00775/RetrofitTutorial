package com.umang_rathod.backend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceholderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("comments")
    Call<List<Comment>> getComments(@Query("postId") int postID, @Query("postId") int postId2);
}
