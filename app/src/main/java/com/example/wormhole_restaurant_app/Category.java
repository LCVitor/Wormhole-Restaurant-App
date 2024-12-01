package com.example.wormhole_restaurant_app;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id") protected int id;
    @SerializedName("name") protected String name;
    @SerializedName("status") protected String status;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = "active";
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
