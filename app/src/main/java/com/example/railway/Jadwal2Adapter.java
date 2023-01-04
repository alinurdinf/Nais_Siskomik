package com.example.railway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Jadwal2Adapter extends RecyclerView.Adapter<Jadwal2Adapter.ViewHolder>{

    private List<DataJadwal> dataList;
    public Jadwal2Adapter(List<DataJadwal> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public Jadwal2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kuliah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Jadwal2Adapter.ViewHolder holder, int position) {
        DataJadwal data = dataList.get(position);
        holder.title.setText(data.getNama_matakuliah());
        holder.ruangan.setText(data.getNama_ruangan());
        holder.jam.setText(data.getJam_mulai());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, ruangan, jam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            ruangan = itemView.findViewById(R.id.ruangan);
            jam = itemView.findViewById(R.id.jam);
        }
    }
}
