package com.app.turistae.api;

import com.app.turistae.model.Categoria;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://192.168.1.6:8080/api/";

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static UsuarioService getUsuarioService() {
        return getClient().create(UsuarioService.class);
    }

    public static TurismoService getTurismoService() {
        return getClient().create(TurismoService.class);
    }

    public static CategoriaService getCategoriaService() {
        return getClient().create(CategoriaService.class);
    }

    public static ImagemService getImagemService() {
        return getClient().create(ImagemService.class);
    }

}
