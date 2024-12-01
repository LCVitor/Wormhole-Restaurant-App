package com.example.wormhole_restaurant_app;

import com.google.gson.annotations.SerializedName;

abstract public class User extends Response{
    @SerializedName("id") protected int id;
    @SerializedName("name") protected String name;
    @SerializedName("password") protected String password;
    @SerializedName("email") protected String email;
    @SerializedName("img") protected String img;
    @SerializedName("status") protected String status;
    @SerializedName("userType") protected String userType;
    @SerializedName("token") protected String token;
    protected String entity;


    public User(int id, String name, String password, String email, String type, String userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.status = "active";
        this.type = type;
        this.userType = userType;
    }

    public User(String email, String password, String userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getUserName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}