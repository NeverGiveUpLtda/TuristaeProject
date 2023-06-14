package com.app.turistae.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.turistae.R;
import com.app.turistae.adapter.TurismoAdapter;
import com.app.turistae.api.ApiClient;
import com.app.turistae.api.TurismoService;
import com.app.turistae.databinding.FragmentHomeBinding;
import com.app.turistae.model.Turismo;

import com.app.turistae.R;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private TurismoService turismoService;
    private RecyclerView recyclerTurismo;
    private TurismoAdapter turismoAdapter;
    private List<Turismo> turismos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        turismoService = ApiClient.getTurismoService();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerTurismo = view.findViewById(R.id.recyclerListaLocais);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        obterTurismos();
    }

    private void obterTurismos() {
        Call<List<Turismo>> call = turismoService.getTurismos();
        call.enqueue(new Callback<List<Turismo>>() {
            @Override
            public void onResponse(Call<List<Turismo>> call, Response<List<Turismo>> response) {
                if (response.isSuccessful()) {
                    turismos = response.body();
                    configurarRecyclerView();
                } else {
                    Log.e("Erro getTurismo", "Resposta não sucedida");
                    Toast.makeText(getContext(), "Erro na requisição get", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Turismo>> call, Throwable t) {
                Log.e("Erro getTurismo", t.getMessage());
            }
        });
    }

    private void configurarRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerTurismo.setLayoutManager(linearLayoutManager);
        turismoAdapter = new TurismoAdapter(turismos, getActivity());
        recyclerTurismo.setAdapter(turismoAdapter);
        recyclerTurismo.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }
}