package com.app.turistae.api;



import com.app.turistae.model.Imagem;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ImagemService {
    @GET("imagem")
    Call<List<Imagem>> getImagens();

    @GET("imagem/{id}")
    Call<Imagem> getImagemById(@Path("id")int id);

    @POST("imagem")
    Call<Imagem> postImagem(@Body Imagem Imagem);

    @DELETE("imagem/{id}")
    Call<Void> deleteImagem(@Path("id") int id);

    @PUT("imagem/{id}")
    Call<Imagem> editImagem(@Path("id") int id, @Body Imagem Imagem);
}
