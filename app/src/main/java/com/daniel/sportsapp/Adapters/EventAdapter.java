package com.daniel.sportsapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.sportsapp.Model.SportEvent;
import com.daniel.sportsapp.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ItemViewHolder> {
    private ArrayList<SportEvent> matches;
    public EventAdapter(ArrayList<SportEvent> items) {
        this.matches = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.event_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        SportEvent match = matches.get(position);
        TextView tvMatchName = holder.tvMatchName;
        TextView tvLeagueName = holder.tvLeagueName;
        TextView tvEventTime = holder.tvEventTime;
        TextView tvEventDate = holder.tvEventDate;
        tvMatchName.setText(match.getStrEvent());
        tvLeagueName.setText(match.getStrLeague());
        tvEventDate.setText(match.getStrDate());
        tvEventTime.setText(match.getStrTime());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMatchName, tvLeagueName, tvEventTime,tvEventDate;
        public ItemViewHolder(View itemView) {
            super(itemView);
            tvMatchName = itemView.findViewById(R.id.tv_event_name);
            tvLeagueName = itemView.findViewById(R.id.tv_league_namex);
            tvEventTime = itemView.findViewById(R.id.tv_event_time);
            tvEventDate = itemView.findViewById(R.id.tv_event_name);
        }
    }
}
