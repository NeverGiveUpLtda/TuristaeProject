package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {

    Button btnEntrar;

    TextView txtCadastrarTurismo, txtCadastrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        txtCadastrarTurismo = findViewById(R.id.txtCadastrarTurismo);
        txtCadastrarUsuario = findViewById(R.id.txtCadastrarUsuario);



        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this, Menu_Navigation.class);
                startActivity(intent);
            }
        });

        txtCadastrarTurismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this, TelaCadastroTurismo.class);
                startActivity(intent);
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
}