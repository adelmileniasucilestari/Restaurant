package com.example.molyst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class Molyst extends RecyclerView.Adapter<Molyst.MolystViewHolder> {

    private final LinkedList<String> mTitle;
    private final LayoutInflater layoutInflater;

    class MolystViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;
        final Molyst molystAdapter;

        public MolystViewHolder(View itemView, Molyst adapter) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            this.molystAdapter = adapter;
        }
    }

    public Molyst(Context context, LinkedList<String> mTitle) {
        layoutInflater = LayoutInflater.from(context);
        this.mTitle = mTitle;
    }

    @Override
    public Molyst.MolystViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new MolystViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(Molyst.MolystViewHolder holder, int position) {
        holder.title.setText(mTitle.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }
}