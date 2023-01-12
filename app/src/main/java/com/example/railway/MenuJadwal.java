package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.SearchView;
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
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jadwal);

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView = findViewById(R.id.searchview);
        dataList = new ArrayList<>();
        List<DataJadwal> filter = new ArrayList<>();


        // create the adapter with the data list
        adapter = new JadwalAdapter(dataList);
        // set the adapter on the recycler view
        recyclerView.setAdapter(adapter);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Clear the filter list
                filter.clear();
                // Iterate through the dataList and add items that match the search query to the filter list
                for (DataJadwal data : dataList) {
                    if (data.getNama_matakuliah().toLowerCase().contains(newText.toLowerCase())) {
                        filter.add(data);
                    }
                }
                // Set the filter list as the data source for the adapter
                adapter.setDataList(filter);
                // Notify the adapter that the data has changed
                adapter.notifyDataSetChanged();
                return true;
            }

        });

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
