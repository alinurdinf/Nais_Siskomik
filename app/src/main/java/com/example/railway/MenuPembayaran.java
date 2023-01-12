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

public class MenuPembayaran extends AppCompatActivity {
    private final String TAG = "MenuPembayaran";

    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    private RecyclerView recyclerView;
    private PembayaranAdapter adapter;
    private List<DataPembayaran> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pembayaran);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        // create the adapter with the data list
        adapter = new PembayaranAdapter(dataList);
        // set the adapter on the recycler view
        recyclerView.setAdapter(adapter);
        getData();
    }
    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://nice.galariks.my.id/Nice_API/")
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

        Call<ResultPembayaran> call = apiInterface.getPembayaran(body);
        call.enqueue(new Callback<ResultPembayaran>() {
            @Override
            public void onResponse(Call<ResultPembayaran> call, Response<ResultPembayaran> response) {
                // parse the response and update the UI
                ResultPembayaran result = response.body();
                List<DataPembayaran> data = result.getResult();
                dataList.addAll(data);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResultPembayaran> call, Throwable t) {
                Log.e(TAG, "On Failure: "+t.getMessage());
            }
        });
    }
}