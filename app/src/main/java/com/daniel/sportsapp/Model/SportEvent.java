package com.daniel.sportsapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SportEvent implements Serializable {

    @SerializedName("idEvent")
    private String idEvent;
    @SerializedName("idSoccerXML")
    private String idSoccerXML;
    @SerializedName("idAPIfootball")
    private String idAPIfootball;
    @SerializedName("strEvent")
    private String strEvent;
    @SerializedName("strEventAlternate")
    private String strEventAlternate;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("idLeague")
    private String idLeague;
    @SerializedName("strLeague")
    private String strLeague;
    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;
    @SerializedName("strHomeTeam")
    private String strHomeTeam;
    @SerializedName("strAwayTeam")
    private String strAwayTeam;
    @SerializedName("intHomeScore")
    private int intHomeScore;
    @SerializedName("intAwayScore")
    private int intAwayScore;
    @SerializedName("strDate")
    private String strDate;
    @SerializedName("strTime")
    private String strTime;

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    public void setIdSoccerXML(String idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
    }

    public String getIdAPIfootball() {
        return idAPIfootball;
    }

    public void setIdAPIfootball(String idAPIfootball) {
        this.idAPIfootball = idAPIfootball;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

    public String getStrEventAlternate() {
        return strEventAlternate;
    }

    public void setStrEventAlternate(String strEventAlternate) {
        this.strEventAlternate = strEventAlternate;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

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

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }

    public int getIntHomeScore() {
        return intHomeScore;
    }

    public void setIntHomeScore(int intHomeScore) {
        this.intHomeScore = intHomeScore;
    }

    public int getIntAwayScore() {
        return intAwayScore;
    }

    public void setIntAwayScore(int intAwayScore) {
        this.intAwayScore = intAwayScore;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    @Override
    public String toString() {
        return "SportEvent{" +
                "idEvent='" + idEvent + '\'' +
                ", idSoccerXML='" + idSoccerXML + '\'' +
                ", idAPIfootball='" + idAPIfootball + '\'' +
                ", strEvent='" + strEvent + '\'' +
                ", strEventAlternate='" + strEventAlternate + '\'' +
                ", strSport='" + strSport + '\'' +
                ", idLeague='" + idLeague + '\'' +
                ", strLeague='" + strLeague + '\'' +
                ", strDescriptionEN='" + strDescriptionEN + '\'' +
                ", strHomeTeam='" + strHomeTeam + '\'' +
                ", strAwayTeam='" + strAwayTeam + '\'' +
                ", intHomeScore=" + intHomeScore +
                ", intAwayScore=" + intAwayScore +
                ", strDate='" + strDate + '\'' +
                ", strTime='" + strTime + '\'' +
                '}';
    }
}
