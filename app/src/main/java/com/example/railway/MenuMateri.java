package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.railway.rerofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuMateri extends AppCompatActivity {
    private final String TAG = "MenuMateri";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MateriAdapter materiAdapter;
    private List<MateriModel.Result> results = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materi);
        setupView();
        setupRecyleview();
        getDataFromApi();

    }

    private void setupRecyleview() {
        materiAdapter = new MateriAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(materiAdapter);
    }

    private void setupView(){
        recyclerView = findViewById(R.id.recycleview);
        progressBar = findViewById(R.id.progressBar);
    }

    private void getDataFromApi() {
        progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getMateri()
                .enqueue(new Callback<MateriModel>() {
                    @Override
                    public void onResponse(Call<MateriModel> call, Response<MateriModel> response) {
                        progressBar.setVisibility((View.GONE));
                        if (response.isSuccessful()) {
                            List<MateriModel.Result> results = response.body().getResult();
                            Log.d(TAG, results.toString());
                            materiAdapter.setData(results);
                        }
                    }

                    @Override
                    public void onFailure(Call<MateriModel> call, Throwable t) {
                        Log.d(TAG, t.toString());
                    }
                });
    }
}