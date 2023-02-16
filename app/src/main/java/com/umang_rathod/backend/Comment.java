package com.umang_rathod.backend;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private int PostId;
    private int id;
    private String name;
    private String email;

    @SerializedName("body")
    private String comment;

    public int getPostId() {
        return PostId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComment() {
        return comment;
    }
}
