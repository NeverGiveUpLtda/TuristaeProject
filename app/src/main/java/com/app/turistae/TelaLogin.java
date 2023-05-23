package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.turistae.api.ApiClient;
import com.app.turistae.api.UsuarioService;
import com.app.turistae.model.MyError;
import com.app.turistae.model.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class TelaLogin extends AppCompatActivity {

    Button btnEntrar;

    TextView txtCadastrarTurismo, txtCadastrarUsuario, txtUsuarioLogin,txtSenhaLogin;


    UsuarioService usuarioService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        usuarioService = ApiClient.getUsuarioService();
        txtCadastrarUsuario = findViewById(R.id.txtCadastrarUsuario);
        txtUsuarioLogin = findViewById(R.id.txtUsuarioLogin);
        txtSenhaLogin = findViewById(R.id.txtSenhaLogin);



        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usu = new Usuario();
                usu.setNomeUsuario(txtUsuarioLogin.getText().toString());
                usu.setSenha(txtSenhaLogin.getText().toString());
                loginusuario(usu);

                // Limpar os campos de login
                txtUsuarioLogin.setText("");
                txtSenhaLogin.setText("");
            }


        });


        txtCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this, TelaCadastrarUsuario.class);
                startActivity(intent);
            }
        });

    }
    private void loginusuario(Usuario usu) {
        Call<Usuario> call = usuarioService.postLoginUsuario(usu);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(TelaLogin.this, Menu_Navigation.class);
                    startActivity(intent);
                }
                else{
                    JSONArray json = null;
                    try {
                        json = new JSONArray( (response.errorBody().string()) );

                      //  String errMsg = json.getString("errors");

                        //Toast.makeText(TelaLogin.this,
                         //       errMsg, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Erro ao logar", t.getMessage());
            }
        });
    }
}