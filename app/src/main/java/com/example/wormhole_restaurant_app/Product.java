package com.example.wormhole_restaurant_app;

import com.google.gson.annotations.SerializedName;

public class Product extends Login {
    @SerializedName("id") private int id;
    @SerializedName("name") private String name;
    @SerializedName("img") private String img;
    @SerializedName("price") private float price;
    @SerializedName("idCategorie") private int idCategorie;
    @SerializedName("description") private String description;
    @SerializedName("status") private String status;

    public Product(int id, String name, String img, float price, int idCategorie, String description) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.idCategorie = idCategorie;
        this.description = description;
        this.status = "active";
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = "active";
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public float getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public int getIdCategorie() {
        return idCategorie;
    }
}
