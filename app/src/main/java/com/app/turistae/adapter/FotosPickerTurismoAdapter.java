package com.app.turistae.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.turistae.R;

import java.util.ArrayList;

public class FotosPickerTurismoAdapter extends RecyclerView.Adapter<FotosPickerTurismoAdapter.ViewHolder> {
    //Incializando var

    ArrayList <Uri> arrayList;

    //Criando constructor
    public FotosPickerTurismoAdapter(ArrayList<Uri> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public FotosPickerTurismoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Incializando view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FotosPickerTurismoAdapter.ViewHolder holder, int position) {
            //Print Image usando uri
        holder.imgView.setImageURI(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        //Passando tamanho da lista
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Incializar Variaveis

        ImageView imgView;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imgView = itemView.findViewById(R.id.iv_image);

        }
    }
}
