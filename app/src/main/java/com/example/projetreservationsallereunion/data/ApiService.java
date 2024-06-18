package com.example.projetreservationsallereunion.data;

import com.application.mygavel.data.models.Client;
import com.application.mygavel.data.models.Dossier;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("/dossiers")
    Call<List<Dossier>> getDossierByAvocatId();

    @GET("/clients")
    Call<List<Client>> getClientsByAvocatId();

    @POST("/dossiers")
    Call<ResponseBody> ajouterDossier(@Body Dossier dossier);

    @POST("/clients")
    Call<ResponseBody> ajouterClient(@Body Client client);

}
