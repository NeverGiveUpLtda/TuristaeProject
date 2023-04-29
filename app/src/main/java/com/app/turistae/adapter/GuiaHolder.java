package com.app.turistae.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.turistae.R;

public class GuiaHolder extends RecyclerView.ViewHolder {
    private ImageView fotoImg;
    private TextView nomeLocalTxt;
    private TextView descricaoTxt;

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

    public GuiaHolder(@NonNull View itemView) {
        super(itemView);
        // por que isso tem que ficar dentro do GuiaHolder?
        nomeLocalTxt = (TextView) itemView.findViewById(R.id.nomeLocalTxt);
        descricaoTxt = (TextView) itemView.findViewById(R.id.descricaoTxt);
        fotoImg = (ImageView) itemView.findViewById(R.id.fotoImg);
    }
}