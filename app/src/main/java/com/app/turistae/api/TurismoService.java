package com.app.turistae.api;



import com.app.turistae.model.Turismo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TurismoService {
    @GET("turismo")
    Call<List<Turismo>> getTurismos();

    @GET("turismo/{id}")
    Call<Turismo> getTurismoById(@Path("id")int id);

    @POST("turismo")
    Call<Turismo> postTurismo(@Body Turismo Turismo);

    @DELETE("turismo/{id}")
    Call<Void> deleteTurismo(@Path("id") int id);

    @PUT("turismo/{id}")
    Call<Turismo> editTurismo(@Path("id") int id, @Body Turismo Turismo);
}
