package com.example.railway;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.railway.databinding.FragmentFraghomeBinding;
import com.example.railway.databinding.FragmentFragicketBinding;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragicket#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragicket extends Fragment {
    FragmentFragicketBinding binding;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    private RecyclerView recyclerView;
    private TugasAdapter adapter;
    private List<DataTugas> dataList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragicket() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragicket.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragicket newInstance(String param1, String param2) {
        Fragicket fragment = new Fragicket();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fragicket, container, false);

        TextView username = (TextView) rootview.findViewById(R.id.nama_mahasiswa);

        sharedPreferences = getActivity().getSharedPreferences("LoginFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        recyclerView = rootview.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));

        username.setText(sharedPreferences.getString("nama_mahasiswa", "Error loading username"));

//        TextView tv_matkul = (TextView) rootview.findViewById(R.id.tv_matkul);
//        tv_matkul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), KnowledgeActivity.class);
//                view.getContext().startActivity(intent);
//            }
//        });

        dataList = new ArrayList<>();

        // create the adapter with the data list
        adapter = new TugasAdapter(dataList);
        // set the adapter on the recycler view
        recyclerView.setAdapter(adapter);

        getData();

        TextView see = (TextView) rootview.findViewById(R.id.seeAll);
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Tugas.class);
                view.getContext().startActivity(intent);
            }
        });
        return rootview;
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nice.galariks.my.id/Nice_API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create the api interface
        ApiEndpoint apiInterface = retrofit.create(ApiEndpoint.class);
        sharedPreferences = getActivity().getSharedPreferences("LoginFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String nim = sharedPreferences.getString("nim", "eror");
        RequestBody body = new FormBody.Builder()
                .add("nim", nim)
                .build();

        Call<ResultTugas> call = apiInterface.getTugas(body);
        call.enqueue(new Callback<ResultTugas>() {
            @Override
            public void onResponse(Call<ResultTugas> call, Response<ResultTugas> response) {
                // parse the response and update the UI
                ResultTugas result = response.body();
                List<DataTugas> data = result.getResult();
                dataList.addAll(data);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResultTugas> call, Throwable t) {
                Log.e(TAG, "On Failure: "+t.getMessage());
            }
        });
    }
}