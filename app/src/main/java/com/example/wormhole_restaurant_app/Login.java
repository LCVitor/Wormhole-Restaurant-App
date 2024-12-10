package com.example.wormhole_restaurant_app;

public class Login {

    protected String type;
    protected String path;
    protected String message;
    protected User user;
    protected boolean success;

    public Login() {

    }

    public String isSuccess() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return this.user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public void setType(boolean type) {
//        this.type = type;
//    }

}
