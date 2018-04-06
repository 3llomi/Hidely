package com.devlomi.hidelysample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.devlomi.hidely.hidelyviews.HidelyImageView;

import java.util.List;

public class ChooseAdapter extends RecyclerView.Adapter<ChooseAdapter.ViewHolder> {


    List<String> users;
    OnItemClick onItemClick;

    public ChooseAdapter(List<String> users, OnItemClick onItemClick) {
        this.users = users;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_choose,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onItemClick.onClick(holder.checkMarkView);
            }
        });

        holder.tvUser.setText(users.get(position));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout rootLayout;
        private HidelyImageView checkMarkView;
        private TextView tvUser;





        public ViewHolder(View itemView) {
            super(itemView);
            rootLayout = itemView.findViewById(R.id.root_layout);
            checkMarkView = itemView.findViewById(R.id.check_mark_view);
            tvUser = itemView.findViewById(R.id.tv_user);

        }
    }
    public interface OnItemClick{
        void onClick(View view);

    }
}
