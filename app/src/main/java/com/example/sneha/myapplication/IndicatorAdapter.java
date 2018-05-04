package com.example.sneha.myapplication;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class IndicatorAdapter extends RecyclerView.Adapter<IndicatorAdapter.IndicatorViewHolder> {

    private static int mPosition;
    private static SparseBooleanArray sSelectedItems;
    //private static UpdateDataClickListener sClickListener;

    ArrayList<Model> arr = new ArrayList<>();

    int selectedPos=0;

    public IndicatorAdapter(ArrayList<Model> arr) {
        this.arr = arr;
        sSelectedItems = new SparseBooleanArray();
    }

    public class IndicatorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView img;
        ConstraintLayout layBk;

        public IndicatorViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.imgPoster);
            layBk = (ConstraintLayout) view.findViewById(R.id.backgroundlayout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            notifyItemChanged(selectedPos);
            selectedPos = getLayoutPosition();
            notifyItemChanged(selectedPos);
        }
    }

    @NonNull
    @Override
    public IndicatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_indicator, parent, false);

        return new IndicatorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull IndicatorViewHolder holder, int position) {
        holder.img.setImageResource(arr.get(position).getImg());

        //holder.itemView.setSelected(selectedPos == position);

        holder.itemView.setBackgroundColor(selectedPos == position ? Color.GREEN : Color.TRANSPARENT);

        holder.layBk.setSelected(sSelectedItems.get(position, false));
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
}
