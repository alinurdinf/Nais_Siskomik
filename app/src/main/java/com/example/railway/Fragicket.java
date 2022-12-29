package com.example.railway;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.railway.databinding.FragmentFraghomeBinding;
import com.example.railway.databinding.FragmentFragicketBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragicket#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragicket extends Fragment {
    FragmentFragicketBinding binding;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
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

        TextView username = (TextView) rootview.findViewById(R.id.username);

        sharedPreferences = getActivity().getSharedPreferences("LoginFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        username.setText(sharedPreferences.getString("nama_mahasiswa", "Error loading username"));

        TextView tv_matkul = (TextView) rootview.findViewById(R.id.tv_matkul);
        tv_matkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), KnowledgeActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        return rootview;
    }
}