package com.example.railway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {
    private List<DataJadwal> dataList;
    private List<DataJadwal> filter;


    public JadwalAdapter(List<DataJadwal> dataList) {
        this.dataList = dataList;
        this.filter = new ArrayList<>(dataList);

    }
    public void setDataList(List<DataJadwal> dataList) {
        this.dataList = dataList;
    }



    @NonNull
    @Override
    public JadwalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jadwal, parent, false);
        return new ViewHolder(view);
    }

    public void search(String query) {
        filter.clear();
        for (DataJadwal data : dataList) {
            if (data.getNama_matakuliah().toLowerCase().contains(query.toLowerCase())) {
                filter.add(data);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalAdapter.ViewHolder holder, int position) {
        DataJadwal data = dataList.get(position);
        holder.title.setText(data.getNama_matakuliah());
        holder.ruangan.setText(data.getNama_ruangan());
        holder.jam.setText(data.getJam_mulai());
        holder.prodi.setText(data.getProgram_studi());

    }

    @Override
    public int getItemCount() {
        return dataList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, ruangan, jam, prodi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            ruangan = itemView.findViewById(R.id.ruangan);
            jam = itemView.findViewById(R.id.jam);
            prodi = itemView.findViewById(R.id.prodi);
        }
    }
}
