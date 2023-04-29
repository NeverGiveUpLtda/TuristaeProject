package com.app.turistae.model;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.app.turistae.MainActivity;
import com.app.turistae.R;
public class TelaLogin extends AppCompatActivity {

    Button entrarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        entrarBtn = (Button) findViewById(R.id.entrarBtn);

        entrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}