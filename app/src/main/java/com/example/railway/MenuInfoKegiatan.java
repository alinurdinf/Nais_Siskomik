package com.example.railway;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.railway.rerofit.ApiService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MenuInfoKegiatan extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private final String TAG = "MenuInfoKegiatan";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private KegiatanAdapter kegiatanAdapter;

    private List<KegiatanModel.Result> results = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_info_kegiatan);
        setupView();
        setupRecyleview();
        getDataFromApi();
        Button button = (Button) findViewById(R.id.bt_date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateString = dateFormat.format(c.getTime());

        Button button = (Button) findViewById(R.id.bt_date);
        button.setText(currentDateString);

        // Filter the results in the adapter using the selected date
        kegiatanAdapter.filterResults(currentDateString);
    }


    private void setupRecyleview() {
        kegiatanAdapter = new KegiatanAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(kegiatanAdapter);
    }

    private void setupView(){
        recyclerView = findViewById(R.id.recycleview);
        progressBar = findViewById(R.id.progressBar);

    }
    private void getDataFromApi(){
        progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getData()
                .enqueue(new Callback<KegiatanModel>() {
                    @Override
                    public void onResponse(Call<KegiatanModel> call, Response<KegiatanModel> response) {
                        progressBar.setVisibility((View.GONE));
                        if (response.isSuccessful()){
                            List<KegiatanModel.Result> results = response.body().getResult();
                            Log.d(TAG, results.toString());
                            kegiatanAdapter.setData(results);
                        }
                    }

                    @Override
                    public void onFailure(Call<KegiatanModel> call, Throwable t) {
                        Log.d(TAG, t.toString());
                    }
                });
    }
}
