package com.example.railway;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.railway.databinding.FragmentFragicketBinding;
import com.example.railway.databinding.FragmentFragprofileBinding;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragprofile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragprofile extends Fragment {
    FragmentFragprofileBinding binding;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragprofile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragprofile.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragprofile newInstance(String param1, String param2) {
        Fragprofile fragment = new Fragprofile();
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
        View rootview = inflater.inflate(R.layout.fragment_fragprofile, container, false);

        ImageView imageView = (ImageView) rootview.findViewById(R.id.myPict);
        TextView nama_mahasiswa = (TextView) rootview.findViewById(R.id.nama_mahasiswa);
        TextView nim = (TextView) rootview.findViewById(R.id.nim);
        TextView logout = (TextView) rootview.findViewById(R.id.logout);
        TextView privacy = (TextView) rootview.findViewById(R.id.privacy1);


        sharedPreferences = getActivity().getSharedPreferences("LoginFile", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        nama_mahasiswa.setText(sharedPreferences.getString("nama_mahasiswa", "Error loading username"));
        nim.setText(sharedPreferences.getString("nim", "Error loading nim"));

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://foul-kitchen-315.notion.site/Nais-Siskomik-040e8844abb8433499a89681fe87e233";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });

        Picasso.get()
                .load(sharedPreferences.getString("foto", "eror"))
                .fit().centerCrop()
                .into(imageView);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("logged_in");
                editor.commit();
                Intent intent = new Intent(v.getContext(), Login.class);
                v.getContext().startActivity(intent);
                getActivity().finish();
            }
        });

        TextView tv_notif = (TextView) rootview.findViewById(R.id.tv_notif);
        tv_notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Notification.class);
                view.getContext().startActivity(intent);
            }
        });
        return rootview;
    }
}