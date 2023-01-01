package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.railway.rerofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuNilai extends AppCompatActivity {
    private final String TAG = "MenuNilai";

    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private NilaiAdapter nilaiAdapter;
    private RequestBody requestBody;
    private List<NilaiModel.Result> results = new ArrayList<>();

    private String nim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_nilai);
//        SharedPreferences sharedPreferences = getSharedPreferences("LoginFile", MODE_PRIVATE);
//        String nim = "1320032";
//        if (nim == null) {
//            // Set the "ni" value to a default value if it is null
//            nim = "default_value";
//        }
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("nim", nim)
//                .build();



        setupView();
        setupRecyleview();
        getDataFromApi();

    }

    private void setupRecyleview() {
        nilaiAdapter = new NilaiAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(nilaiAdapter);
    }

    private void setupView(){
        recyclerView = findViewById(R.id.recycleview);
        progressBar = findViewById(R.id.progressBar);
    }
    private void getDataFromApi() {
        sharedPreferences = getSharedPreferences("LoginFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String nim = sharedPreferences.getString("nim", "");

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("nim", nim)
                .build();

        progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getNilai(requestBody)
                .enqueue(new Callback<NilaiModel>() {
                    @Override
                    public void onResponse(Call<NilaiModel> call, Response<NilaiModel> response) {
                        progressBar.setVisibility((View.GONE));
                        if (response.isSuccessful()) {
                            List<NilaiModel.Result> results = response.body().getResult();
                            Log.d(TAG, results.toString());
                            nilaiAdapter.setData(results);
                        }
                    }

                    @Override
                    public void onFailure(Call<NilaiModel> call, Throwable t) {
                        Log.d(TAG, t.toString());
                    }
                });
    }
}