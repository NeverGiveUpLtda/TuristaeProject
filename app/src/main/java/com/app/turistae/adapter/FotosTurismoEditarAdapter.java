package com.app.turistae.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.turistae.R;
import com.app.turistae.TelaEditarTurismo;
import com.app.turistae.dataset.GuiaDataset;
import com.app.turistae.model.Locais;

import java.util.List;

public class FotosTurismoEditarAdapter extends RecyclerView.Adapter<FotosTurismoEditarHolder> {

    // DUVIDA: tem lista e método de manipulação de lista sendo criados aqui e no dataset, porquê? nao é só em um lugar que precisa?
    private List<Locais> listaLocais;
    public FotosTurismoEditarAdapter(List<Locais> listaLocais){ this.listaLocais = listaLocais;}

    private Context context;

    @NonNull
    @Override
    // o que ta acontecendo aqui?
    public FotosTurismoEditarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FotosTurismoEditarHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_modelo_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FotosTurismoEditarHolder holder, int position) {
        Locais locais = listaLocais.get(position);
        holder.getNomeLocalTxt().setText(locais.getNomeLocal());
        holder.getFotoImg().setImageResource(locais.getFotoLocal());


        holder.getBtnEditar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context, TelaEditarTurismo.class);
//                EXEMPLOS
//                intent.putExtra("nome", turismo.getNome());
//                intent.putExtra("fotos", turismo.getImagens());
//                intent.putExtra("descricao", turismo.getDescricao());
//                intent.putExtra("site", turismo.getSite());
//                intent.putExtra("mapa", turismo.getMapa());
//                intent.putExtra("telefone", turismo.getNumero());
//                intent.putExtra("foto", turismo.getFoto());


                context.startActivity(intent);

            }
        });
    }

    ;


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