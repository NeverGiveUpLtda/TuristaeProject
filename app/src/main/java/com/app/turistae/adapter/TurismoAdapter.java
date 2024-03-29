package com.app.turistae.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.turistae.R;
import com.app.turistae.TelaSaibaMais;
import com.app.turistae.api.ApiClient;
import com.app.turistae.api.TurismoService;
import com.app.turistae.model.Imagem;
import com.app.turistae.model.Turismo;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TurismoAdapter extends RecyclerView.Adapter<TurismoAdapter.TurismoViewHolder> {
    private final List<Turismo> turismos;
    Context context;

    public TurismoAdapter(List<Turismo> turismos, Context context){
        this.context = context;
        this.turismos = turismos;
    }

    @NonNull
    @Override
    public TurismoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TurismoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_modelo_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TurismoViewHolder holder, int position) {
        Turismo tur = turismos.get(position);
        holder.getDescricaoTxt().setText(tur.getDescricao());
        holder.getNomeLocalTxt().setText(tur.getNome());

        List<Imagem> imagens = tur.getImagens();
        if (imagens != null && !imagens.isEmpty()) {
            Imagem primeiraImagemBase64 = imagens.get(0);
            // Converter a primeira imagem Base64 de volta para um formato de imagem
            byte[] decodedString = Base64.decode(primeiraImagemBase64.getString64(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            // Definir a imagem na ImageView
            holder.getFotoImg().setImageBitmap(decodedByte);
        }

        holder.getBtnSaibaMais().setOnClickListener(view -> {
            int turismoId = tur.getId(); // Obtém o ID do turismo
            abrirTelaSaibaMais(turismoId);
        });


    }


    private void abrirTelaSaibaMais(int turismoId) {
        Intent intent = new Intent(context, TelaSaibaMais.class);
        intent.putExtra("turismoId", turismoId);
        context.startActivity(intent);
    }





//    private void econtrar(int position) {
//        int id = turismos.get(position).getId();
//        TurismoService apiService = ApiClient.getTurismoService();
//        Call<Turismo> call = apiService.getTurismoById(id);
//        call.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if(response.isSuccessful()){
//                    turismos.remove(position);
//                    notifyItemRemoved(position);
//                    notifyItemRangeChanged(position,usuarios.size());
//                    Toast.makeText(context, "Excluído com sucesso!"
//                            , Toast.LENGTH_SHORT).show();
//                }else{
//                    Log.e("Exclusao Usuario",response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Log.e("Exclusao Usuario",t.getMessage());
//            }
//        });
//    }


    @Override
    public int getItemCount() {
        return turismos != null ? turismos.size() : 0;
    }

    public class TurismoViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoImg;
        private TextView nomeLocalTxt;
        private TextView descricaoTxt;

        private Button btnSaibaMais;

        public Button getBtnSaibaMais() {
            return btnSaibaMais;
        }

        public void setBtnSaibaMais(Button btnSaibaMais) {
            this.btnSaibaMais = btnSaibaMais;
        }

        // getter e setter nome local
        public TextView getNomeLocalTxt() {
            return nomeLocalTxt;
        }

        public void setNomeLocalTxt(TextView nomeLocalTxt) {
            this.nomeLocalTxt= nomeLocalTxt;
        }

        // getter e setter descricao
        public TextView getDescricaoTxt() {
            return descricaoTxt;
        }

        public void setDescricaoTxt(TextView descricaoTxt) {
            this.descricaoTxt = descricaoTxt;
        }

        // getter e setter foto local
        public ImageView getFotoImg() {
            return fotoImg;
        }

        public void setFotoImg(ImageView fotoImg) {
            this.fotoImg = fotoImg;
        }

        public TurismoViewHolder(@NonNull View itemView) {
            super(itemView);
            // por que isso tem que ficar dentro do GuiaHolder?
            nomeLocalTxt = (TextView) itemView.findViewById(R.id.nomeLocalTxt);
            descricaoTxt = (TextView) itemView.findViewById(R.id.descricaoTxt);
            fotoImg = (ImageView) itemView.findViewById(R.id.fotoImgEditar);
            btnSaibaMais = (Button) itemView.findViewById(R.id.btnSaibaMaisTurismo);
        }
    }
}
