package com.app.turistae.api;



import com.app.turistae.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioService {
    @GET("usuario")
    Call<List<Usuario>> getUsuarios();

    @GET("usuario/{id}")
    Call<Usuario> getUsuarioById(@Path("id")int id);

    @POST("usuario")
    Call<Integer> postUsuario(@Body Usuario usuario);

    @POST("usuario/login")
    Call<Usuario> postLoginUsuario(@Body Usuario usuario);

    @DELETE("usuario/{id}")
    Call<Void> deleteUsuario(@Path("id") int id);

    @PUT("usuario/{id}")
    Call<Void> editUsuario(@Path("id") int id, @Body Usuario usuario);
}
