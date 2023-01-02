package com.example.railway.rerofit;

import com.example.railway.KegiatanModel;
import com.example.railway.MateriModel;
import com.example.railway.NewsModel;
import com.example.railway.NilaiModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndpoint {
    @GET("Kegiatan.php")
    Call<KegiatanModel> getData();

    @GET("Materi.php")
    Call<MateriModel> getMateri();

    @GET("News.php")
    Call<NewsModel> getNews();

    @POST("nilai.php")
    Call<NilaiModel> getNilai(@Body RequestBody request);
}
