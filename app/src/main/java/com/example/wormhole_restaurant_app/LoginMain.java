package com.example.wormhole_restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginMain extends AppCompatActivity {

    Button btnLogin;
    TextView txtMessage;
    EditText etxEmail;
    EditText etxPassword;
    RadioGroup rgTypeUser;
    String typeUser = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rgTypeUser = findViewById(R.id.rgTypeUser);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
                Log.d("Clique no botão de login", "Entrei!!");
            }
        });

    }

    private void login() {
        txtMessage = findViewById(R.id.txtMessageLogin);
        etxEmail = findViewById(R.id.etxEmail);
        etxPassword = findViewById(R.id.etxPassword);

        Log.d("TESTE", String.valueOf(rgTypeUser.getCheckedRadioButtonId()));
        if (rgTypeUser.getCheckedRadioButtonId() == R.id.rbClient) {
            typeUser = "client";
        } else if (rgTypeUser.getCheckedRadioButtonId() == R.id.rbDeliveryman) {
            typeUser = "deliveryman";
        }
        else {
            txtMessage.setText("Selecione todos os campos!");
//            return;
        }

        User user = new Client(etxEmail.getText().toString(), etxPassword.getText().toString(), typeUser);
//        Log.d("batatat", user.email);

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", user.getEmail())
                .addFormDataPart("password", user.getPassword())
                .addFormDataPart("userType", user.getTypeUser())
                .build();
        Call call = RetrofitClient.getInstance().getMyApi().login(requestBody);
        Log.e("ERROR 3", call.toString());

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("TESTE", response.toString());
                Login user1 = (Login) response.body();

                if (user1.isSuccess().equals("success")) {
                    txtMessage.setText(user1.getMessage());
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    Log.i("tag","A Kiss after 5 seconds");
                                    Intent it = new Intent(LoginMain.this, MainActivity.class);
                                    it.putExtra("user", user1.getUser().getUserName());
                                    startActivity(it);
                                }
                            }, 3000);
                } else {
                    //a API retorna uma mensagem de erro quando o login não for bem sucedido
                    //usei otvFullname para exibir a mensagem de erro
                    txtMessage.setText(user1.getMessage());
                    Log.e("TESTE", "Entrei aqui!!!");
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginMain.this, "Ocorreu um erro", Toast.LENGTH_LONG).show();
                Log.e("ERROR", t.toString());
                Log.e("ERROR 2", call.toString());
            }
        });
    }
}