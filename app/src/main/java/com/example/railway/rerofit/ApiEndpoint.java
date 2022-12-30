package com.example.railway.rerofit;

import com.example.railway.KegiatanModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("Kegiatan.php")
    Call<KegiatanModel> getData();
}
