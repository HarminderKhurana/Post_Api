package com.developer.post_api;

import com.google.gson.annotations.SerializedName;

public class DataModel {
private String title;
@SerializedName("body")
    private String text;
private int userId;

    public DataModel(String title, String text, int userId) {
        this.title = title;
        this.text = text;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    private Integer id;
}
