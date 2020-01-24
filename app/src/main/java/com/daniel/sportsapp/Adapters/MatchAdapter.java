package com.daniel.sportsapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.sportsapp.Model.Sport;
import com.daniel.sportsapp.Model.SportEvent;
import com.daniel.sportsapp.R;

import java.util.ArrayList;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ItemViewHolder> {
    private ArrayList<SportEvent> matches;
    public MatchAdapter(ArrayList<SportEvent> items) {
        this.matches = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.match_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        SportEvent match = matches.get(position);
        TextView tvMatchName = holder.tvMatchName;
        TextView tvLeagueName = holder.tvLeagueName;
        TextView tvHomeTeam = holder.tvHomeTeam;
        TextView tvHomeScore = holder.tvHomeScore;
        TextView tvAwayTeam = holder.tvAwayTeam;
        TextView tvAwayScore = holder.tvAwayScore;
        tvMatchName.setText(match.getStrEvent());
        tvLeagueName.setText(match.getStrLeague());
        tvHomeTeam.setText(match.getStrHomeTeam());
        tvHomeScore.setText(Integer.toString(match.getIntHomeScore()));
        tvAwayTeam.setText(match.getStrAwayTeam());
        tvAwayScore.setText(Integer.toString(match.getIntAwayScore()));
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMatchName, tvLeagueName, tvHomeTeam,tvAwayTeam,tvHomeScore,tvAwayScore;
        public ItemViewHolder(View itemView) {
            super(itemView);
            tvMatchName = itemView.findViewById(R.id.tv_match_name);
            tvLeagueName = itemView.findViewById(R.id.tv_league_name);
            tvHomeTeam = itemView.findViewById(R.id.tv_home_team);
            tvHomeScore = itemView.findViewById(R.id.tv_home_score);
            tvAwayTeam = itemView.findViewById(R.id.tv_away_team);
            tvAwayScore = itemView.findViewById(R.id.tv_away_score);
        }
    }
}
