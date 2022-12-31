package com.example.railway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KegiatanAdapter extends RecyclerView.Adapter<KegiatanAdapter.viewholder> {

    private List<KegiatanModel.Result> results = new ArrayList<>();
    public KegiatanAdapter(List<KegiatanModel.Result> results){
        this.results = results;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        KegiatanModel.Result result = results.get(position);
        holder.title.setText(result.getNama_kegiatan());
        holder.desc.setText((result.getDesc_kegiatan()));
        holder.tanggal.setText(result.getTgl_kegiatan());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView title, desc, tanggal;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.matkul1);
            desc = itemView.findViewById(R.id.desc);
            tanggal = itemView.findViewById(R.id.tanggal);
        }
    }
    public void setData(List<KegiatanModel.Result> data) {
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
    }
