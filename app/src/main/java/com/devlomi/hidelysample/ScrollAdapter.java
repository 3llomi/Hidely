package com.devlomi.hidelysample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScrollAdapter extends RecyclerView.Adapter<ScrollAdapter.ViewHolder> {

    String[] dummyArray;

    public ScrollAdapter(String[] dummyArray) {
        this.dummyArray = dummyArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_scroll,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = dummyArray[position];
        holder.tvItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return dummyArray.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItem;


        public ViewHolder(View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);

        }
    }
}
