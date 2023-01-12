package com.example.railway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Data> dataList;

    public DataAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nilai, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = dataList.get(position);
//        holder.nim.setText(data.getNim());
        holder.nama_matakuliah.setText(data.getNamaMatakuliah());
        holder.semester.setText(data.getSemester());
        holder.nilai.setText(data.getNilai());
        holder.sks.setText(data.getSks()+" Sks");

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void semester1(String semester) {
        List<Data> filteredData = new ArrayList<>();
        for (Data data : dataList) {
            if (data.getSemester().contains(semester)) {
                filteredData.add(data);
            }
        }
        dataList = filteredData;
        notifyDataSetChanged();
    }

    public void semester2(String semester) {
        List<Data> filteredData = new ArrayList<>();
        for (Data data : dataList) {
            if (data.getSemester().contains(semester)) {
                filteredData.add(data);
            }
        }
        dataList = filteredData;
        notifyDataSetChanged();
    }

    public void semester3(String semester) {
        List<Data> filteredData = new ArrayList<>();
        for (Data data : dataList) {
            if (data.getSemester().contains(semester)) {
                filteredData.add(data);
            }
        }
        dataList = filteredData;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nim;
        TextView nama_matakuliah;
        TextView semester;
        TextView nilai;
        TextView sks;



        public ViewHolder(View itemView) {
            super(itemView);
//            nim = itemView.findViewById(R.id.nim);
            nama_matakuliah = itemView.findViewById(R.id.nama_matkul);
            semester = itemView.findViewById(R.id.semester);
            sks = itemView.findViewById(R.id.sks);
            nilai = itemView.findViewById(R.id.nilaiMatkul);

        }
    }
}

