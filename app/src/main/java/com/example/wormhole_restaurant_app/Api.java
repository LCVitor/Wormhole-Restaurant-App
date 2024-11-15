package com.example.wormhole_restaurant_app;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
//    String BASE_URL = "https://simplifiedcoding.net/demos/";
//    @GET("marvel")
//    Call<List<Hero>> getSuperHeroes();
    String BASE_URL = "http://10.0.2.2/android/";

    //login com GET enviando os dados no header
    @GET("login_test.php")
    Call<User> loginWithGet(@Header("username") String username, @Header("password") String password);

    //login com POST
    @POST("login_test.php")
    Call<User> loginWithPost(@Body User user);
}

