package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.railway.rerofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuMateri extends AppCompatActivity {
    private final String TAG = "MenuMateri";
    private RecyclerView recyclerView;
    private SearchView searchView;
//    private ProgressBar progressBar;
    private MateriAdapter materiAdapter;
    private List<MateriModel.Result> results = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materi);
        searchView = findViewById(R.id.searchview);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform the search here
                materiAdapter.filterResults(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    // Set the original data as the new data
                    getDataFromApi();
                } else {
                    // Create a new SpannableString with the search query
                    SpannableString spannableString = new SpannableString(newText);

                    // Apply a style to the search query using the SPAN_INCLUSIVE_INCLUSIVE flag
                    spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, newText.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                    // Filter the results using the styled search query
                    materiAdapter.filterResults(spannableString);
                }
                return true;
            }


        });
        setupView();
        setupRecyleview();
        getDataFromApi();

    }

    private void setupRecyleview() {
        materiAdapter = new MateriAdapter(results, new MateriAdapter.OnClickLister() {
            @Override
            public void OnClick(MateriModel.Result result) {
                String url = result.getMateri();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(materiAdapter);
    }

    private void setupView(){
        recyclerView = findViewById(R.id.recycleview);
//        progressBar = findViewById(R.id.progressBar);
    }

    private void getDataFromApi() {
//        progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getMateri()
                .enqueue(new Callback<MateriModel>() {
                    @Override
                    public void onResponse(Call<MateriModel> call, Response<MateriModel> response) {
//                        progressBar.setVisibility((View.GONE));
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