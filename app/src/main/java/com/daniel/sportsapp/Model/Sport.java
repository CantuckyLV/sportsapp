package com.daniel.sportsapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sport implements Serializable {
    @SerializedName("idSport")
    private String idSport;
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("strFormat")
    private String strFormat;
    @SerializedName("strSportThumb")
    private String strSportThumb;
    @SerializedName("strSportDescription")
    private String strSportDescription;

    public String getIdSport() {
        return idSport;
    }

    public void setIdSport(String idSport) {
        this.idSport = idSport;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrFormat() {
        return strFormat;
    }

    public void setStrFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }

    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

    public String getStrSportDescription() {
        return strSportDescription;
    }

    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "idSport='" + idSport + '\'' +
                ", strSport='" + strSport + '\'' +
                ", strFormat='" + strFormat + '\'' +
                ", strSportThumb='" + strSportThumb + '\'' +
                ", strSportDescription='" + strSportDescription + '\'' +
                '}';
    }
}
