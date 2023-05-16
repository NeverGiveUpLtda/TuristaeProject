package com.app.turistae;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.app.turistae.adapter.FotosPickerTurismoAdapter;

import java.util.ArrayList;
import java.util.List;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class TelaEditarTurismo extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    Button btnFoto;
    RecyclerView recyclerView;

    ArrayList<Uri> listaImagens = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_editar_turismo);

        btnFoto = findViewById(R.id.btnPick);
        recyclerView = findViewById(R.id.recyclerFotosTurismo);

        //Set listenet on button
        btnFoto.setOnClickListener(view -> {
            String[] strings = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};

            if (EasyPermissions.hasPermissions(this,strings)){
                imagePicker();
            }else {
                //Qunado permissao for recusada
                //Pedir permissao
                EasyPermissions.requestPermissions(this, "Aplicativo quer acessar sua camera e armazenamento", 100, strings);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null){
            //Quando activity conter datat
            if (requestCode == FilePickerConst.REQUEST_CODE_PHOTO){
                //Quando o request for foto
                //Inicializar array list de imagens
                listaImagens = data.getParcelableArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new FotosPickerTurismoAdapter(listaImagens));
            }
        }
    }


    private void imagePicker() {
        FilePickerBuilder.getInstance()
                .setActivityTitle("Selecione as imagens")
                .setSpan(FilePickerConst.SPAN_TYPE.FOLDER_SPAN, 3)
                .setSpan(FilePickerConst.SPAN_TYPE.DETAIL_SPAN,3)
                .setMaxCount(4)
                .setSelectedFiles(listaImagens)
                .setActivityTheme(R.style.CustomTheme)
                .pickPhoto(this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        //Check condicao
        if (requestCode == 100 && perms.size() == 2){
            imagePicker();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            new AppSettingsDialog.Builder(this).build().show();
        }else {
            Toast.makeText(getApplicationContext(),"Permissão recusada", Toast.LENGTH_SHORT).show();
        }
    }
}