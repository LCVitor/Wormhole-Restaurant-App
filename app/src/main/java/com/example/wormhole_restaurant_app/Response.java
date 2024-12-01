package com.example.wormhole_restaurant_app;

abstract public class Response {

    protected String type;
    protected String path;
    protected String message;
    protected boolean success;

    public String isSuccess() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
