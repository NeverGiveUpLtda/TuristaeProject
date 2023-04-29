package com.example.aula5.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula5.R;
import com.example.aula5.dataset.GuiaDataset;
import com.example.aula5.Locais;

import java.util.List;

public class GuiaAdapter extends RecyclerView.Adapter<GuiaHolder> {

    // DUVIDA: tem lista e método de manipulação de lista sendo criados aqui e no dataset, porquê? nao é só em um lugar que precisa?
    private List<Locais> listaLocais;
    public GuiaAdapter(List<Locais> listaLocais){ this.listaLocais = listaLocais;}

    @NonNull
    @Override
    // o que ta acontecendo aqui?
    public GuiaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GuiaHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_modelo_item,parent,false));
    };

    @Override
    public void onBindViewHolder(@NonNull GuiaHolder holder, int position) {
        Locais locais = listaLocais.get(position);

        holder.getNomeLocalTxt().setText(locais.getNomeLocal());
        holder.getDescricaoTxt().setText(String.valueOf(locais.getDescricaoLocal()));
        holder.getFotoImg().setImageResource(locais.getFotoLocal());
    }

    // onde isso ta sendo usado?
    private void removeritem(int position) {
        listaLocais.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,listaLocais.size());
    }

    public void adicionarItem(Locais local){
        GuiaDataset.addLocal(local);
        notifyItemInserted(getItemCount());
    }

    @Override
    public int getItemCount() {
        return listaLocais == null ? 0 : listaLocais.size();
    }
}