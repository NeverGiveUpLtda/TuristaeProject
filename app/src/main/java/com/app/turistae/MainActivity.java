package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import com.app.turistae.adapter.GuiaAdapter;
import com.app.turistae.dataset.GuiaDataset;

public class MainActivity extends AppCompatActivity {

    private boolean grid = false;
    RecyclerView recyclerGuia;
    private GuiaAdapter guiaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);
        setupRecycler();
    }

    public void setupRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerGuia = findViewById(R.id.recyclerGuiaTuristico);
        recyclerGuia.setLayoutManager(layoutManager);

        // setando o adapter
        guiaAdapter = new GuiaAdapter(GuiaDataset.getLista());
        recyclerGuia.setAdapter(guiaAdapter);
        recyclerGuia.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    // o que ta acontecendo aqui?
    public void addLocalClick(View view) {
        //COMO ADICIONAR O BOTAO E A FOTO??
        guiaAdapter.adicionarItem(new Locais("Local 1", "É um local", 1));
    }
}