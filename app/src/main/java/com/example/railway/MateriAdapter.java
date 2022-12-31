package com.example.railway;


import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.viewholder> {
    private List<MateriModel.Result> results = new ArrayList<>();
    public MateriAdapter(List<MateriModel.Result> results){
        this.results = results;

    }

    @NonNull
    @Override
    public MateriAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MateriAdapter.viewholder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materi, parent, false)

        );
    }

    @Override
    public void onBindViewHolder(@NonNull MateriAdapter.viewholder holder, int position) {
        MateriModel.Result result = results.get(position);
        holder.title.setText(result.getJudul_materi());
        holder.dosen.setText(result.getNama_dosen());
        holder.id.setText(result.getId());
        final String url = result.getMateri();
        holder.link.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            result.startActivity(i);
        });


    }

    @Override
    public int getItemCount() {
        return results.size();
    }




    public class viewholder extends RecyclerView.ViewHolder {
        TextView title,dosen,id,link;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            dosen = itemView.findViewById(R.id.dosen);
            link = itemView.findViewById(R.id.link);
            id = itemView.findViewById(R.id.id);

        }


    }
    public void setData(List<MateriModel.Result> data) {
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();

    }
}

