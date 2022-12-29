package com.example.railway;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.railway.databinding.FragmentFraghomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fraghome#newInstance} factory method to
 * create an instance of this fragment.
 */

public class Fraghome extends Fragment {
    FragmentFraghomeBinding binding;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fraghome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fraghome.
     */
    // TODO: Rename and change types and number of parameters
    public static Fraghome newInstance(String param1, String param2) {
        Fraghome fragment = new Fraghome();
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
    TextView jadwal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fraghome, container, false);

        TextView jadwal = (TextView) rootview.findViewById(R.id.jadwal);
        TextView nilai = (TextView) rootview.findViewById(R.id.nilai);
        TextView grafik = (TextView) rootview.findViewById(R.id.grafikips);
        TextView materi = (TextView) rootview.findViewById(R.id.materi);
        TextView absensi = (TextView) rootview.findViewById(R.id.absensi);
        TextView info = (TextView) rootview.findViewById(R.id.info);
        TextView nama_mahasiwa = (TextView) rootview.findViewById(R.id.nama_mahasiswa);
        TextView username = (TextView) rootview.findViewById(R.id.username);
        TextView pembayaran = (TextView) rootview.findViewById(R.id.pembayaran);
        TextView program_studi = (TextView) rootview.findViewById(R.id.program_studi);

        sharedPreferences = getActivity().getSharedPreferences("LoginFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        nama_mahasiwa.setText(sharedPreferences.getString("nama_mahasiswa", "Error loading Nama Mahasiswa"));
        username.setText(sharedPreferences.getString("nim", "Error loading username"));
        program_studi.setText(sharedPreferences.getString("program_studi", "Error loading Program Studi"));
        jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuJadwal.class);
                view.getContext().startActivity(intent);
            }
        });
        nilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuNilai.class);
                view.getContext().startActivity(intent);
            }
        });
        grafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuGrafikIps.class);
                view.getContext().startActivity(intent);
            }
        });
        materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuMateri.class);
                view.getContext().startActivity(intent);
            }
        });
        absensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuAbsen.class);
                view.getContext().startActivity(intent);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuInfoKegiatan.class);
                view.getContext().startActivity(intent);
            }
        });
        pembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MenuPembayaran.class);
                view.getContext().startActivity(intent);
            }
        });
        return rootview;
    }
}