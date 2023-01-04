package com.example.railway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PembayaranAdapter extends RecyclerView.Adapter<PembayaranAdapter.ViewHolder> {
    private List<DataPembayaran> dataList;
    public PembayaranAdapter(List<DataPembayaran> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public PembayaranAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pembayaran, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PembayaranAdapter.ViewHolder holder, int position) {
        DataPembayaran data = dataList.get(position);
        holder.semester.setText(data.getSemester());
        holder.tgl_bayar.setText(data.getTgl_bayar());
        holder.status.setText(data.getStatus());
//        holder.link.setText(data.getFile());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView semester, tgl_bayar, status, link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            semester = itemView.findViewById(R.id.title);
            tgl_bayar = itemView.findViewById(R.id.tgl_bayar);
            status = itemView.findViewById(R.id.status);
            link = itemView.findViewById(R.id.link);
        }
    }
}
