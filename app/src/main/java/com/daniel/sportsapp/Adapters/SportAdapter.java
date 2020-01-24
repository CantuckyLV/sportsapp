package com.daniel.sportsapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.sportsapp.Model.Sport;
import com.daniel.sportsapp.R;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ItemViewHolder> {
    private ArrayList<Sport> sports;
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.simple_item, parent, false);
        return new ItemViewHolder(itemView,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Sport sport = sports.get(position);
        TextView sportName = holder.sportName;
        sportName.setText(sport.getStrSport());
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public SportAdapter(ArrayList<Sport> items, OnItemClickListener mOnItemClickListener) {
        this.sports = items;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView sportName;
        OnItemClickListener onItemClickListener;
        public ItemViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            sportName = itemView.findViewById(R.id.sport_name);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
