package com.daniel.sportsapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class EventsResponse implements Serializable {
    @SerializedName("events")
    private ArrayList<SportEvent> events;

    public ArrayList<SportEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<SportEvent> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventsResponse{" +
                "events=" + events +
                '}';
    }
}
