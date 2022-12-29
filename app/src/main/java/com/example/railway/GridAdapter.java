package com.example.railway;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.temporal.Temporal;

public class GridAdapter extends BaseAdapter {
    Context context;
    String[] flowerName;
    int[] image;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] flowerName, int[] image){
        this.context = context;
        this.flowerName = flowerName;
        this.image = image;
    }

    @Override
    public int getCount() {
        return flowerName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertview == null){
            convertview = inflater.inflate(R.layout.grid_item, null);

        }

        ImageView imageView = convertview.findViewById(R.id.grid_image);

        imageView.setImageResource(image[position]);
        return convertview;
    }
}

