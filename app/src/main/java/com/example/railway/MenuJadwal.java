package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.railway.rerofit.ApiEndpoint;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuJadwal extends AppCompatActivity {
    private final String TAG = "MenuJadwal";

    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    private RecyclerView recyclerView;
    private JadwalAdapter adapter;
    private List<DataJadwal> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jadwal);

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        // create the adapter with the data list
        adapter = new JadwalAdapter(dataList);
        // set the adapter on the recycler view
        recyclerView.setAdapter(adapter);

        getData();
    }
    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nice.galariks.my.id/Nice_API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create the api interface
        ApiEndpoint apiInterface = retrofit.create(ApiEndpoint.class);
        sharedPreferences = getSharedPreferences("LoginFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String nim = sharedPreferences.getString("nim", "eror");
        RequestBody body = new FormBody.Builder()
                .add("nim", nim)
                .build();

        Call<ResultJadwal> call = apiInterface.getJadwal(body);
        call.enqueue(new Callback<ResultJadwal>() {
            @Override
            public void onResponse(Call<ResultJadwal> call, Response<ResultJadwal> response) {
                // parse the response and update the UI
                ResultJadwal result = response.body();
                List<DataJadwal> data = result.getResult();
                dataList.addAll(data);
                adapter.notifyDataSetChanged();

                Toast.makeText(MenuJadwal.this, nim, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResultJadwal> call, Throwable t) {
                Log.e(TAG, "On Failure: "+t.getMessage());
            }
        });
    }
}
