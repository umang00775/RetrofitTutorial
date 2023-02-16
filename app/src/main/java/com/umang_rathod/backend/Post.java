package com.umang_rathod.backend;

import com.google.gson.annotations.SerializedName;

public class Post {
    //This all are for response
    private int userId;
    private int id;
    private String title;

    @SerializedName("body") //Json and Gson are different
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
