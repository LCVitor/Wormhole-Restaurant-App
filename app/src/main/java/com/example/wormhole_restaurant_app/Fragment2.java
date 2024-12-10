package com.example.wormhole_restaurant_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
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
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        TextView tvId = getView().findViewById(R.id.tvIdPost);
//        TextView tvFullname = getView().findViewById(R.id.tvFullnamePost);
//        login(tvId, tvFullname);
    }

//    private void login(TextView tvId, TextView tvFullname) {
//        User user = new Client("rey@gmail.com", "teste", "client");
//        Log.d("batatat", user.email);
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("email", user.getEmail())
//                .addFormDataPart("password", user.getPassword())
//                .addFormDataPart("userType", user.getTypeUser())
//                .build();
//        Call call = RetrofitClient.getInstance().getMyApi().login(requestBody);
//        Log.e("ERROR 3", call.toString());
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                Log.d("TESTE", response.toString());
//                Login user1 = (Login) response.body();
//
//                TextView tvIdInternal = tvId;
//                TextView tvFullnameInternal = tvFullname;
//
//                if (user1.isSuccess().equals("success")) {
//                    tvIdInternal.setText("" + user1.getUser().getId());
//                    tvFullnameInternal.setText(user1.getUser().getUserName());
//                } else {
//                    //a API retorna uma mensagem de erro quando o login não for bem sucedido
//                    //usei otvFullname para exibir a mensagem de erro
//                    tvFullnameInternal.setText(user1.getMessage());
//                    Log.e("TESTE", "Entrei aqui!!!");
//                }
//            }
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Toast.makeText(getContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
//                Log.e("ERROR", t.toString());
//                Log.e("ERROR 2", call.toString());
//            }
//        });
//    }
}