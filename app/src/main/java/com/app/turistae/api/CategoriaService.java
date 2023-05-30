package com.app.turistae.api;



import com.app.turistae.model.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CategoriaService {
    @GET("categoria")
    Call<List<Categoria>> getCategorias();

    @GET("categoria/{id}")
    Call<Categoria> getCategoriaById(@Path("id")int id);

    @POST("categoria")
    Call<Categoria> postCategoria(@Body Categoria Turismo);

    @DELETE("categoria/{id}")
    Call<Void> deleteCategoria(@Path("id") int id);

    @PUT("categoria/{id}")
    Call<Categoria> editCategoria(@Path("id") int id, @Body Categoria Turismo);
}
