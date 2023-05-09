package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.app.turistae.adapter.GuiaAdapter;
import com.app.turistae.dataset.GuiaDataset;
import com.app.turistae.model.Locais;

public class TelaListaTurismos extends AppCompatActivity {

    private boolean grid = false;
    RecyclerView recyclerListaTurismo;
    private GuiaAdapter guiaAdapter;

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
        guiaAdapter = new GuiaAdapter(GuiaDataset.getLista());
        recyclerListaTurismo.setAdapter(guiaAdapter);

        recyclerListaTurismo.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    // o que ta acontecendo aqui?
    public void addLocalClick(View view) {
        //COMO ADICIONAR O BOTAO E A FOTO??
        guiaAdapter.adicionarItem(new Locais("Local 1", "É um local", 1));
    }
}
