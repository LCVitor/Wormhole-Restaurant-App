package com.example.wormhole_restaurant_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListProducts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListProducts extends Fragment {

    ArrayList<Product> products;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListProducts() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListProducts.
     */
    // TODO: Rename and change types and number of parameters
    public static ListProducts newInstance(String param1, String param2) {
        ListProducts fragment = new ListProducts();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_products, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        TextView txt = getView().findViewById(R.id.txtTest);
        RecyclerView rvProds = getView().findViewById(R.id.rvProducts);
        getProd(rvProds);
//        ArrayList products = getArguments().getParcelableArrayList("lista_de_dados");
//        for (Product p : products) {
//            txt.setText(p.getName());
//        }

    }

    private void getProd(RecyclerView rvProds) {
        Call<List<Product>> call = RetrofitClient.getInstance().getMyApi().getProdName();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> prodList = response.body();
                products = new ArrayList<Product>();
                for (Product prod : prodList) {
                    Product p = new Product(prod.getId(), prod.getName(), prod.getImg(), prod.getPrice(), prod.getIdCategorie(), prod.getDescription());
                    products.add(p);
                }

                RecyclerView rvProducts = rvProds;
                MyAdapter adapter = new MyAdapter(products);
                RecyclerView.LayoutManager layout =
                        new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                rvProducts.setLayoutManager(layout);
                rvProducts.setAdapter(adapter);

//                sendData(products, fragment);
//                String[] p = new String[ prodList.size() ];
//                for (int i = 0; i < p.length; i++) {
//                    p[i] = prodList.get(i).getName() + " " + prodList.get(i).getId();
//                }
//                ArrayAdapter<String> heroesAdapter =
//                        new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, p);
//                superListView.setAdapter(heroesAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(), "Ocorreu um erro. " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}