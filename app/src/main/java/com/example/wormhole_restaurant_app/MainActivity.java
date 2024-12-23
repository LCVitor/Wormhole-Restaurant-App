package com.example.wormhole_restaurant_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    ListView superListView;
    Button btn_home;
//    ArrayList<Product> products;

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

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                ListProducts listPrdsFragment = new ListProducts();
//                getProd(listPrdsFragment);
                fragmentTransaction.replace(R.id.fragmentContainerView, listPrdsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
//        superListView = findViewById(R.id.superListView);
//        getSuperHeroes();
//        login();
//        loginWithGet();
//        getProdName();
    }
//    public void sendData(ArrayList<Product> data, Fragment fragment) {
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList("Lista_de_dados", data);
//        fragment.setArguments(bundle);
//    }

//    private void getProd(Fragment fragment) {
//        Call<List<Product>> call = RetrofitClient.getInstance().getMyApi().getProdName();
//        call.enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//                List<Product> prodList = response.body();
//                products = new ArrayList<Product>();
//                for (Product prod : prodList) {
//                    Product p = new Product(prod.getId(), prod.getName(), prod.getImg(), prod.getPrice(), prod.getIdCategorie(), prod.getDescription());
//                    products.add(p);
//                }
//                sendData(products, fragment);
////                String[] p = new String[ prodList.size() ];
////                for (int i = 0; i < p.length; i++) {
////                    p[i] = prodList.get(i).getName() + " " + prodList.get(i).getId();
////                }
////                ArrayAdapter<String> heroesAdapter =
////                        new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, p);
////                superListView.setAdapter(heroesAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Ocorreu um erro. " + t.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

//    private void login() {
//        User user = new Client("rey@gmail.com", "teste", "client");
//        Call<User> call = RetrofitClient.getInstance().getMyApi().login(user);
//        Log.e("ERROR 3", call.toString());
//
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user1 = response.body();
//
//                TextView tvId = findViewById(R.id.tvIdPost);
//                TextView tvFullname = findViewById(R.id.tvFullnamePost);
//
//                if (user1.isSuccess() == "success") {
//                    tvId.setText("" + user1.getId());
//                    tvFullname.setText(user1.getUserName());
//                } else {
//                    //a API retorna uma mensagem de erro quando o login não for bem sucedido
//                    //usei otvFullname para exibir a mensagem de erro
//                    tvFullname.setText(user1.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
//                Log.e("ERROR", t.toString());
//                Log.e("ERROR 2", call.toString());
//            }
//        });
//    }
//
//    private void loginWithGet() {
//
//        //só muda isto, o restante é igual
//        Call<User> call = RetrofitClient.getInstance().getMyApi().loginWithGet("felipe", "12345");
//
//        //a chamada é igual ao método loginWithPost, poderia ser substituida por um método
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user1 = response.body();
//
//                TextView tvId = findViewById(R.id.tvId);
//                TextView tvFullname = findViewById(R.id.tvFullname);
//
//                if (user1.isSuccess()) {
//                    tvId.setText("" + user1.getId());
//                    tvFullname.setText(user1.getFullname());
//                } else {
//                    tvFullname.setText(user1.getMessage());
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
//                Log.e("TESTE", t.toString());
//            }
//        });
//
//    }

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