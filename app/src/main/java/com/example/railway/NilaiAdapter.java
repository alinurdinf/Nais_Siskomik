package com.example.railway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NilaiAdapter extends RecyclerView.Adapter<NilaiAdapter.viewholder> {
    private List<NilaiModel.Result> results = new ArrayList<>();

    public NilaiAdapter(List<NilaiModel.Result> results){
        this.results = results;
    }


    @NonNull
    @Override
    public NilaiAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nilai, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NilaiAdapter.viewholder holder, int position) {
        NilaiModel.Result result = results.get(position);
        holder.nama.setText(result.getNama_matakuliah());
        holder.semester.setText(result.getSemester());
        holder.nilai.setText(result.getNilai());
        holder.sks.setText(result.getSks());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setData(List<NilaiModel.Result> data) {
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView nama, semester, nilai, sks;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama_matkul);
            semester = itemView.findViewById(R.id.semester);
            nilai = itemView.findViewById(R.id.nilai);
            sks = itemView.findViewById(R.id.sks);

        }
    }
}
