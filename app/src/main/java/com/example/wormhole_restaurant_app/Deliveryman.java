package com.example.wormhole_restaurant_app;

public class Deliveryman extends User{
    public Deliveryman(int id, String name, String password, String email, String userType) {
        super(id, name, password, email, userType);
        super.entity = "deliverymans";
    }
}
