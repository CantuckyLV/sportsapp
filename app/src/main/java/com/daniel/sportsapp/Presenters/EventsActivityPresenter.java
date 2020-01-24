package com.daniel.sportsapp.Presenters;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daniel.sportsapp.Model.EventsResponse;
import com.daniel.sportsapp.Model.League;
import com.daniel.sportsapp.Model.LeaguesResponse;
import com.daniel.sportsapp.Model.SportEvent;
import com.daniel.sportsapp.Model.Sport;
import com.daniel.sportsapp.SportsRequestQueue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class EventsActivityPresenter {
    private View view;
    private Sport sport;
    private ArrayList<SportEvent> events = new ArrayList<>();
    private ArrayList<League> leagues = new ArrayList<>();
    private ArrayList<League> usefulLeagues = new ArrayList<>();
    String LEAGUES_URL = "https://www.thesportsdb.com/api/v1/json/1/all_leagues.php";
    String EVENTS_BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=";
    String EVENTS_UPDATE_URL = "https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=";
    private int numberOfRequests = 0;
    private Bundle bundle;
    private Context context;
    int first = 0;
    private final Timer timer = new Timer();

    public EventsActivityPresenter(View view) {
        this.view = view;
    }

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //TODO handle errors: connection and such
        }
    };
    public void requestLeagues(Context context, Bundle bundle) {
        if(bundle != null) {
            sport = (Sport) bundle.getSerializable("sport");
        }
        this.bundle = bundle;
        this.context = context;
        view.showProgressDialog();
        RequestQueue queue = SportsRequestQueue.getInstance(context).getRequestQueue();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(LEAGUES_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response!=null){
                    VolleyLog.wtf(response.toString(), "utf-8");
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    LeaguesResponse leaguesResponse = gson.fromJson(response.toString(),LeaguesResponse.class);
                    leagues = leaguesResponse.getLeagues();
                    for(League league:leagues){
                        if(league.getStrSport().equals(sport.getStrSport())){
                            usefulLeagues.add(league);
                        }
                    }
                    requestEvents();
                }

            }
        }, errorListener) {

            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };
        queue.add(jsonObjectRequest);

    }
    public void requestEvents(){
        final RequestQueue queue = SportsRequestQueue.getInstance(context).getRequestQueue();
        for(League league:usefulLeagues){
                String petitionURL = EVENTS_BASE_URL+league.getIdLeague();
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(petitionURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if(response!=null){
                            try{
                                VolleyLog.wtf(response.toString(), "utf-8");
                                GsonBuilder builder = new GsonBuilder();
                                Gson gson = builder.create();
                                EventsResponse eventsResponse = gson.fromJson(response.toString(),EventsResponse.class);
                                if(eventsResponse.getEvents()!=null){
                                    events.addAll(eventsResponse.getEvents());
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }


                        }

                    }
                }, errorListener) {

                    @Override
                    public String getBodyContentType() {
                        return "application/json";
                    }

                    @Override
                    public Priority getPriority() {
                        return Priority.NORMAL;
                    }
                };
                queue.add(jsonObjectRequest);
        }
        queue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
                try {
                    if (request.getCacheEntry() != null) {
                        String cacheValue = new String(request.getCacheEntry().data, "UTF-8");
                        numberOfRequests++;
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (numberOfRequests == usefulLeagues.size()) {
                    if(first == 0){
                        first = 1;
                        numberOfRequests = 0;
                        view.hideProgressDialog();
                        view.setUpEventsList(events);
                        startTimer();
                    }

                }
            }
        });
    }
    public void refreshEvents(){
        RequestQueue queues = SportsRequestQueue.getInstance(context).getRequestQueue();
        for(int i=0; i<events.size();i++){
            final SportEvent sportEventTMP = events.get(i);
            String eventID = sportEventTMP.getIdEvent();
            String petitionURL = EVENTS_UPDATE_URL+eventID;
            final int finalI = i;
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(petitionURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(response!=null){
                        try{
                            VolleyLog.wtf(response.toString(), "utf-8");
                            GsonBuilder builder = new GsonBuilder();
                            Gson gson = builder.create();
                            EventsResponse eventsResponse = gson.fromJson(response.toString(),EventsResponse.class);
                            Log.e("halp 1:"+events.get(finalI).getStrEvent(),"halp 2:"+eventsResponse.getEvents().get(0).getStrEvent());
                            events.set(finalI,eventsResponse.getEvents().get(0));
                            view.refreshEventList(finalI);
                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }

                }
            }, errorListener) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Priority getPriority() {
                    return Priority.NORMAL;
                }
            };
            queues.add(jsonObjectRequest);
        }
    }
    public void startTimer(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Log.e("startrefresh","holp");
                refreshEvents();
            }
        }, 0, 30000);
    }
    public void stopTimer(){
        timer.cancel();
        timer.purge();
    }
    public interface View{
        void showProgressDialog();
        void hideProgressDialog();
        void setUpEventsList(ArrayList<SportEvent> events);
        void refreshEventList(int position);
    }
}
