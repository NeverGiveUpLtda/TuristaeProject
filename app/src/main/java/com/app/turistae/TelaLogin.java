package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaLogin extends AppCompatActivity {

    Button btnEntrar, btnCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCriarConta = (Button) findViewById(R.id.btnCriarConta);



        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this, Menu_Navigation.class);
                startActivity(intent);
            }
        });




    }
}