package com.example.railway;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.railway.rerofit.ApiEndpoint;
import com.example.railway.rerofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuNilai extends AppCompatActivity {
    private final String TAG = "MenuNilai";

    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private List<Data> dataList;
    private SearchView searchView;
    private Button semester1, semester2, semester3;

    private String nim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_nilai);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView = findViewById(R.id.search);

        List<Data> filter = new ArrayList<>();
        dataList = new ArrayList<>();

        // create the adapter with the data list
        adapter = new DataAdapter(dataList);
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
                for (Data data : dataList) {
                    if (data.getNamaMatakuliah().toLowerCase().contains(newText.toLowerCase())) {
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

        int originalColor;
        semester1 = findViewById(R.id.semester1);
        semester1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.semester1("Semester 1");
//                semester1.setBackgroundColor(getResources().getColor(R.color.black));
//                semester1.setTextColor(getResources().getColor(R.color.white));
            }
        });
        semester2 = findViewById(R.id.semester2);
        semester2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.semester2("Semester 2");
//                semester1.setBackgroundColor(getResources().getColor(R.color.black));
//                semester1.setTextColor(getResources().getColor(R.color.white));
            }
        });
        semester3 = findViewById(R.id.semester3);
        semester3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.semester3("Semester 3");
//                semester1.setBackgroundColor(getResources().getColor(R.color.black));
//                semester1.setTextColor(getResources().getColor(R.color.white));
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

        Call<Result> call = apiInterface.getData(body);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                // parse the response and update the UI
                Result result = response.body();
                List<Data> data = result.getResult();
                dataList.addAll(data);
                adapter.notifyDataSetChanged();

                Toast.makeText(MenuNilai.this, nim, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e(TAG, "On Failure: "+t.getMessage());
            }
        });
    }
}