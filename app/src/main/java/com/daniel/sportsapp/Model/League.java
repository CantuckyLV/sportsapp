package com.daniel.sportsapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class League implements Serializable {

    @SerializedName("idLeague")
    private String idLeague;
    @SerializedName("strLeague")
    private String strLeague;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("strLeagueAlternate")
    private String strLeagueAlternate;

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }

    @Override
    public String toString() {
        return "League{" +
                "idLeague='" + idLeague + '\'' +
                ", strLeague='" + strLeague + '\'' +
                ", strSport='" + strSport + '\'' +
                ", strLeagueAlternate='" + strLeagueAlternate + '\'' +
                '}';
    }
}
