package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.net.Uri;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.turistae.utils.CustomSlideModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;


import com.app.turistae.api.ApiClient;
import com.app.turistae.api.TurismoService;
import com.app.turistae.model.Imagem;
import com.app.turistae.model.Turismo;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaSaibaMais extends AppCompatActivity {
    private TextView nomeTurismoTxt, txtDescricao, txtEndereco, Estrelinha, txtAvaliar;

    private ImageView fotosTurismo;

    private RatingBar estrelinha;

    private String telefoneString, enderecoCompleto;

    private Button btnEnviar, btnFav, btnTelefone, btnMapa;

    private ImageSlider imageSlider;


    private TurismoService turismoService;

    private ArrayList<CustomSlideModel> slideModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_saiba_mais);

        turismoService = ApiClient.getTurismoService();

        nomeTurismoTxt = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtEndereco = findViewById(R.id.txtEndereco);
        estrelinha = findViewById(R.id.Estrelinha);
        txtAvaliar = findViewById(R.id.txtAvaliar);

        imageSlider = findViewById(R.id.imageSlider);


        btnTelefone = findViewById(R.id.btnTelefone);
        btnMapa = findViewById(R.id.btnMap);

        // Obter o ID do turismo passado como extra
        int turismoId = getIntent().getIntExtra("turismoId", 0);

        // Fazer uma chamada à API para obter os detalhes do turismo com base no ID
        obterTurismoPorId(turismoId);

        btnTelefone.setOnClickListener(v -> {
            // Verificar se o número de telefone não está vazio
            if (telefoneString != null && !telefoneString.isEmpty()) {
                // Criar uma intent para realizar a chamada telefônica
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + telefoneString));
                startActivity(intent);
            } else {
                Toast.makeText(TelaSaibaMais.this, "Número de telefone inválido", Toast.LENGTH_SHORT).show();
            }
        });


        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar se o endereço não está vazio
                if (enderecoCompleto != null && !enderecoCompleto.isEmpty()) {
                    Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(enderecoCompleto));
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });


    }

    private void obterTurismoPorId(int turismoId) {
        Call<Turismo> call = turismoService.getTurismoById(turismoId);
        call.enqueue(new Callback<Turismo>() {
            @Override
            public void onResponse(Call<Turismo> call, Response<Turismo> response) {
                if (response.isSuccessful()) {
                    Turismo turismo = response.body();
                    if (turismo != null) {
                        // Exibir as informações do turismo na tela
                        exibirInformacoesTurismo(turismo);
                    }
                } else {
                    Log.e("Erro getTurismo", "Resposta não sucedida");
                    Toast.makeText(TelaSaibaMais.this, "Erro na requisição get", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Turismo> call, Throwable t) {
                Log.e("Erro getTurismo", t.getMessage());
            }
        });
    }




    private void exibirInformacoesTurismo(Turismo turismo) {
        telefoneString = String.valueOf(turismo.getTelefone());
        enderecoCompleto = turismo.getRua().toString() + ", " + turismo.getNumeroLocal() + " - " + turismo.getBairro() + ", " + turismo.getCidade() + " - " + turismo.getEstado();
        nomeTurismoTxt.setText(turismo.getNome());
        txtDescricao.setText(turismo.getDescricao());
        txtEndereco.setText(enderecoCompleto);


        List<Imagem> imagens = turismo.getImagens();
        List<SlideModel> slideModels = new ArrayList<>();

        for (Imagem imagem : imagens) {
            String base64Image = imagem.getString64();
            if (base64Image != null && !base64Image.isEmpty()) {
                Toast.makeText(TelaSaibaMais.this, "AOBA 64", Toast.LENGTH_SHORT).show();
                // Converter base64 para bitmap
                byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
                Bitmap decodedBitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                if (decodedBitmap != null) {
                    Toast.makeText(TelaSaibaMais.this, "tem imagem BIT", Toast.LENGTH_SHORT).show();
                    // Salvar a imagem em um arquivo local ou enviar para um servidor
                    String imagePath = saveImageToFile(decodedBitmap);

                    // Verificar se o caminho da imagem foi obtido com sucesso
                    if (imagePath != null) {
                        // Adicionar a URL do caminho da imagem à lista slideModels
                        slideModels.add(new SlideModel(Uri.fromFile(new File(imagePath)).toString(), ScaleTypes.FIT));
                    }
                }
            }
        }

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }

    private String saveImageToFile(Bitmap bitmap) {
        Context context = getApplicationContext();

        // Crie um subdiretório para suas imagens, se necessário
        File imageDirectory = new File(context.getFilesDir(), "images");
        if (!imageDirectory.exists()) {
            imageDirectory.mkdirs();
        }

        // Crie um nome de arquivo único para a imagem
        String fileName = "image_" + System.currentTimeMillis() + ".jpg";

        // Crie o arquivo no diretório especificado
        File file = new File(imageDirectory, fileName);
        FileOutputStream outStream;

        try {
            // Salve o bitmap no arquivo
            outStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
