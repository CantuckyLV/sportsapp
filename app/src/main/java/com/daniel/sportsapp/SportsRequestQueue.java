package com.daniel.sportsapp;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SportsRequestQueue {
    protected static SportsRequestQueue instance;
    protected Context context;
    protected RequestQueue requestQueue;

    public SportsRequestQueue(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized SportsRequestQueue getInstance(Context context) {
        if (instance == null) {
            instance = new SportsRequestQueue(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

}
