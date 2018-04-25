package com.example.aminapc.novosti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.NovostViewHolder> {
    private Context mCtx;
    private List<Novosti> novostList;

    public Adapter(Context mCtx, List<Novosti> novostList) {
        this.mCtx = mCtx;
        this.novostList = novostList;
    }

    @Override
    public NovostViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new NovostViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(NovostViewHolder holder, int position) {
        Novosti novost = novostList.get(position);
        Glide.with(mCtx)
                .load(novost.getSlika())
                .into(holder.imageView);
        holder.textViewNaslov.setText(novost.getNaslov());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return novostList.size();
    }

    class NovostViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNaslov;
        ImageView imageView;

        public NovostViewHolder(View itemView) {
            super(itemView);
            textViewNaslov = itemView.findViewById(R.id.naslov);
            imageView = itemView.findViewById(R.id.slika);
        }
    }
}
