package com.daniel.sportsapp.Presenters;

import android.content.Context;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daniel.sportsapp.Model.Sport;
import com.daniel.sportsapp.Model.SportsResponse;
import com.daniel.sportsapp.SportsRequestQueue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityPresenter {

    private View view;
    private ArrayList<Sport> sports = new ArrayList<>();
    String SPORTS_URL = "https://www.thesportsdb.com/api/v1/json/1/all_sports.php";

    public MainActivityPresenter(View view) {
        this.view = view;
    }

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //TODO handle errors: connection and such
        }
    };
    public void requestSports(Context context) {
        view.showProgressDialog();
        RequestQueue queue = SportsRequestQueue.getInstance(context).getRequestQueue();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(SPORTS_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response!=null){
                    VolleyLog.wtf(response.toString(), "utf-8");
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    view.hideProgressDialog();
                    SportsResponse sportsResponse = gson.fromJson(response.toString(),SportsResponse.class);
                    sports = sportsResponse.getSports();
                    view.setupSportsList(sports);
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

    public void sportSelected(int position){
        Sport tmpSport = sports.get(position);
        view.goToSport(tmpSport);
    }

    public interface View{
        void showProgressDialog();
        void hideProgressDialog();
        void setupSportsList(ArrayList<Sport> sports);
        void goToSport(Sport sport);
    }

}
