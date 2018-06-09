package com.example.dodo.bakingreceipes.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dodo.bakingreceipes.ReceipeActivity;

public class ReceipeAdapter extends RecyclerView.Adapter


{


    public ReceipeAdapter(ReceipeActivity activity) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface ListItemClickListener {
    }
}
