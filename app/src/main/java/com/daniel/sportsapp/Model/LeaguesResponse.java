package com.daniel.sportsapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LeaguesResponse {
    @SerializedName("leagues")
    private ArrayList<League> leagues;

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(ArrayList<League> leagues) {
        this.leagues = leagues;
    }

    @Override
    public String toString() {
        return "LeaguesResponse{" +
                "leagues=" + leagues +
                '}';
    }
}
