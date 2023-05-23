package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaCadastroTurismo extends AppCompatActivity {


    Button btnCancelar, btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_turismo);

        btnCancelar = (Button) findViewById(R.id.btnCancelarCadUser);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrarUsuario);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}