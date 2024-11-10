package com.example.wormhole_restaurant_app;

import com.google.gson.annotations.SerializedName;

public class User {
    //A classe user é uma POJO super simples, pois somente informamos
    //os atributos que iremos enviar e receber da nossa API
    @SerializedName("user_id")
    private int id;
    private String username;
    private String password;
    private String fullname;

    //estes atributos podem ser definidos em uma outra classe (Response) e a classe User herdaria dela
    //para para fins didáticos, inseri os atributos da resposta aqui para facilitar
    private boolean success;
    private String message;

    public User(int id, String username, String password, String fullname, boolean success, String message) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.success = success;
        this.message = message;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}