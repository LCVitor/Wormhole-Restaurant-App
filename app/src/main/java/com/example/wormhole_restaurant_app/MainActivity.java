package com.example.wormhole_restaurant_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    ListView superListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        superListView = findViewById(R.id.superListView);
//        getSuperHeroes();
        loginWithPost();
        loginWithGet();
    }
    private void loginWithPost() {
        User user = new User("felipe", "12345");
        Call<User> call = RetrofitClient.getInstance().getMyApi().loginWithPost(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();

                TextView tvId = findViewById(R.id.tvIdPost);
                TextView tvFullname = findViewById(R.id.tvFullnamePost);

                if (user1.isSuccess()) {
                    tvId.setText("" + user1.getId());
                    tvFullname.setText(user1.getFullname());
                } else {
                    //a API retorna uma mensagem de erro quando o login não for bem sucedido
                    //usei otvFullname para exibir a mensagem de erro
                    tvFullname.setText(user1.getMessage());
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
                Log.e("TESTE", t.toString());
            }
        });
    }

    private void loginWithGet() {

        //só muda isto, o restante é igual
        Call<User> call = RetrofitClient.getInstance().getMyApi().loginWithGet("felipe", "12345");

        //a chamada é igual ao método loginWithPost, poderia ser substituida por um método
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();

                TextView tvId = findViewById(R.id.tvId);
                TextView tvFullname = findViewById(R.id.tvFullname);

                if (user1.isSuccess()) {
                    tvId.setText("" + user1.getId());
                    tvFullname.setText(user1.getFullname());
                } else {
                    tvFullname.setText(user1.getMessage());
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
                Log.e("TESTE", t.toString());
            }
        });

    }

//    private void getSuperHeroes() {
//        Call<List<Hero>> call = RetrofitClient.getInstance().getMyApi().getSuperHeroes();
//        call.enqueue(new Callback<List<Hero>>() {
//            @Override
//            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
//                List<Hero> heroList = response.body();
//                String[] heroes = new String[ heroList.size() ];
//                for (int i = 0; i < heroes.length; i++) {
//                    heroes[i] = heroList.get(i).getName();
//                }
//                ArrayAdapter<String> heroesAdapter =
//                        new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes);
//                superListView.setAdapter(heroesAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<Hero>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Ocorreu um erro. " + t.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}