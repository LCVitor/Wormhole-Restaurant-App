package com.example.wormhole_restaurant_app;

public class Deliveryman extends User{
    public Deliveryman(int id, String name, String password, String email, String type ,String userType) {
        super(id, name, password, email, type, userType);
        super.entity = "deliverymans";
    }
}
