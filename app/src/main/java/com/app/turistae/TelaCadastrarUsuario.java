package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaCadastrarUsuario extends AppCompatActivity {

    Button btnCancelar, btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_usuario);

        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    finish();
                }
        });
    }

}