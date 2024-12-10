package com.example.wormhole_restaurant_app;

public class Client extends User{

    public Client(int id, String name, String password, String email, String userType) {
        super(id, name, password, email, userType);
        super.entity = "clients";
    }

    public Client(String email, String password, String userType) {
        super(email, password, userType);
    }
}
