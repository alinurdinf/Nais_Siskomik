package com.example.railway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.viewholder> {
    private List<NewsModel.Result> results = new ArrayList<>();
    public NewsAdapter(List<NewsModel.Result> results){
        this.results = results;
    }

    @NonNull
    @Override
    public NewsAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsAdapter.viewholder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.viewholder holder, int position) {
        NewsModel.Result result = results.get(position);
        holder.title.setText(result.getTitle());
        holder.tgl_rilis.setText(result.getTgl_berita());
        holder.penulis.setText(result.getPenulis());
        Picasso.get()
                .load(result.getImage())
                .fit().centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setData(List<NewsModel.Result> data) {
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView title, tgl_rilis, penulis;
        ImageView imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            tgl_rilis = itemView.findViewById(R.id.tgl_rilis);
            penulis = itemView.findViewById(R.id.penulis);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
