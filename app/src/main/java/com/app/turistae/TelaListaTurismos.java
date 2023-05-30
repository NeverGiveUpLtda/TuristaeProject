package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TelaListaTurismos extends AppCompatActivity {

    private boolean grid = false;
    RecyclerView recyclerListaTurismo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_turismos);
        setupRecycler();
    }

    public void setupRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerListaTurismo = findViewById(R.id.recyclerListaTurismos);
        recyclerListaTurismo.setLayoutManager(layoutManager);

        // setando o adapter
//        guiaAdapter = new GuiaAdapter(GuiaDataset.getLista());


        recyclerListaTurismo.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    // o que ta acontecendo aqui?

}
