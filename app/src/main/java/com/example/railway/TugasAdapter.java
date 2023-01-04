package com.example.railway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.ViewHolder> {
    private List<DataTugas> dataList;

    public TugasAdapter(List<DataTugas> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public TugasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tugas, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TugasAdapter.ViewHolder holder, int position) {
        DataTugas data = dataList.get(position);
        holder.nama_tugas.setText(data.getNama_tugas());
        holder.dl_tugas.setText(data.getDl_tugas());
        holder.status.setText(data.getStatus());
        holder.bind(data);




    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama_tugas, dl_tugas, status, desc_tugas;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_tugas = itemView.findViewById(R.id.nama_tugas);
            dl_tugas = itemView.findViewById(R.id.waktu);
            status = itemView.findViewById(R.id.status);
            desc_tugas = itemView.findViewById(R.id.desc_tugas);
        }
        void bind(DataTugas data) {
            String descTugas = data.getDesc_tugas();
            if (descTugas.length() > 70) {
                descTugas = descTugas.substring(0, 70) + "...";
            }
            desc_tugas.setText(descTugas);
            // bind other views
        }
    }
}
