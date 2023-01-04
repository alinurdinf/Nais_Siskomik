package com.example.railway.rerofit;

import com.example.railway.KegiatanModel;
import com.example.railway.MateriModel;
import com.example.railway.NewsModel;
import com.example.railway.Result;
import com.example.railway.ResultJadwal;
import com.example.railway.ResultJadwal2;
import com.example.railway.ResultPembayaran;
import com.example.railway.ResultTugas;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndpoint {
    @GET("Kegiatan.php")
    Call<KegiatanModel> getData();

    @GET("Materi.php")
    Call<MateriModel> getMateri();

    @GET("News.php")
    Call<NewsModel> getNews();

    @POST("Nilai.php")
    Call<Result> getData(@Body RequestBody body);

    @POST("Tugas.php")
    Call<ResultTugas> getTugas(@Body RequestBody body);

    @POST("Jadwal.php")
    Call<ResultJadwal> getJadwal(@Body RequestBody body);

    @POST("Jadwal.php")
    Call<ResultJadwal2> getJadwal2(@Body RequestBody body);

    @POST("Pembayaran.php")
    Call<ResultPembayaran> getPembayaran(@Body RequestBody body);
}
