package com.daniel.sportsapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SportsResponse {
    @SerializedName("sports")
    private ArrayList<Sport> sports;

    public ArrayList<Sport> getSports() {
        return sports;
    }

    public void setSports(ArrayList<Sport> sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "SportsResponse{" +
                "sports=" + sports +
                '}';
    }
}
