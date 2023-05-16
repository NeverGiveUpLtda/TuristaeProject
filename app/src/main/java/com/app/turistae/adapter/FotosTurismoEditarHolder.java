package com.app.turistae.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.turistae.R;

public class FotosTurismoEditarHolder extends RecyclerView.ViewHolder {
    private ImageView fotoImg;
    private TextView nomeLocalTxt;

    private Button btnEditar;

    // getter e setter nome local
    public TextView getNomeLocalTxt() {
        return nomeLocalTxt;
    }

    public void setNomeLocalTxt(TextView nomeLocalTxt) {
        this.nomeLocalTxt= nomeLocalTxt;
    }

    public Button getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(Button btnEditar) {
        this.btnEditar = btnEditar;
    }

    // getter e setter foto local
    public ImageView getFotoImg() {
        return fotoImg;
    }

    public void setFotoImg(ImageView fotoImg) {
        this.fotoImg = fotoImg;
    }

    public FotosTurismoEditarHolder(@NonNull View itemView) {
        super(itemView);
        // por que isso tem que ficar dentro do GuiaHolder?
        nomeLocalTxt = (TextView) itemView.findViewById(R.id.nomeLocalTxt);
        btnEditar = (Button) itemView.findViewById(R.id.btnEditarTurismo);
        fotoImg = (ImageView) itemView.findViewById(R.id.fotoImgEditar);
    }
}