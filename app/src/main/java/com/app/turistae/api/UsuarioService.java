package com.app.turistae.api;

import com.example.exemploapiretrofit.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioService {
    @GET("Usuario")
    Call<List<Usuario>> getUsuarios();

    @GET("Usuario/{id}")
    Call<Usuario> getUsuarioById(@Path("id")int id);

    @POST("Usuario")
    Call<Usuario> postUsuario(@Body Usuario usuario);

    @DELETE("Usuario/{id}")
    Call<Void> deleteUsuario(@Path("id") int id);

    @PUT("Usuario/{id}")
    Call<Usuario> editUsuario(@Path("id") int id, @Body Usuario usuario);
}
