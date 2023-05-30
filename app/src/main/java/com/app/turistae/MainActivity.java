package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import com.app.turistae.adapter.TurismoAdapter;
import com.app.turistae.api.ApiClient;
import com.app.turistae.api.TurismoService;
import com.app.turistae.model.Turismo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TurismoService turismoService;
    RecyclerView recyclerTurismo;

    TurismoAdapter turismoAdapter;
    List<Turismo> turismos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        recyclerTurismo = (RecyclerView)findViewById(R.id.recyclerListaLocais);
        turismoService = ApiClient.getTurismoService();

    }

    @Override
    protected void onResume() {
        super.onResume();
        obterTurismos();
    }
    private void obterTurismos() {

        Call<List<Turismo>> call = turismoService.getTurismos();
        call.enqueue(new Callback<List<Turismo>>() {

            @Override
            public void onResponse(Call<List<Turismo>> call, Response<List<Turismo>> response) {
                turismos = response.body();
                configurarReclycerTurismo();
            }

            @Override
            public void onFailure(Call<List<Turismo>> call, Throwable t) {
                Log.e("Erro getTurismo",t.getMessage());

            }
        });
        }



    private void configurarReclycerTurismo() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerTurismo.setLayoutManager(linearLayoutManager);
        turismoAdapter = new TurismoAdapter(turismos,this);
        recyclerTurismo.setAdapter(turismoAdapter);
        recyclerTurismo.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
    }
