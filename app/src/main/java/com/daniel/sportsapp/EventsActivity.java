package com.daniel.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.daniel.sportsapp.Adapters.EventAdapter;
import com.daniel.sportsapp.Adapters.MatchAdapter;
import com.daniel.sportsapp.Model.SportEvent;
import com.daniel.sportsapp.Presenters.EventsActivityPresenter;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity implements EventsActivityPresenter.View {
    private EventsActivityPresenter presenter;
    private MatchAdapter matchAdapter;
    private EventAdapter eventAdapter;
    private RecyclerView rvEvents;
    private RelativeLayout rlProgressT;
    int eventType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        presenter = new EventsActivityPresenter(this);
        setupView();
    }
    @Override
    public void onStop()
    {
        super.onStop();
        presenter.stopTimer();
    }

    private void setupView(){
        rvEvents = findViewById(R.id.rv_events);
        rlProgressT = findViewById(R.id.rl_progress_t);
        Bundle bundle = getIntent().getExtras();
        presenter.requestLeagues(EventsActivity.this, bundle);
    }

    @Override
    public void showProgressDialog() {
        rlProgressT.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        rlProgressT.setVisibility(View.GONE);
    }

    @Override
    public void setUpEventsList(ArrayList<SportEvent> events) {
        try{
            SportEvent tmp = events.get(0);
            switch (tmp.getStrSport()){
                case "Soccer":
                case"Baseball":
                case"Basketball":
                case"American Football":
                case"Ice Hockey":
                case"Rugby":
                case"Cricket":
                case"Australian Football":
                case"Volleyball":
                case"Netball":
                case"Handball":
                case"Field Hockey":
                    Log.e("set","matchess");
                    eventType = 1;
                    matchAdapter = new MatchAdapter(events);
                    rvEvents.setAdapter(matchAdapter);
                    rvEvents.setLayoutManager(new LinearLayoutManager(this));
                    break;
                default:
                    Log.e("set","events");
                    eventType = 2;
                    eventAdapter = new EventAdapter(events);
                    rvEvents.setAdapter(eventAdapter);
                    rvEvents.setLayoutManager(new LinearLayoutManager(this));
                    break;

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void refreshEventList(int position) {
        if(eventType == 1){
            matchAdapter.notifyItemChanged(position);
        }else{
            eventAdapter.notifyItemChanged(position);
        }
    }
}
