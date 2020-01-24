package com.daniel.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.daniel.sportsapp.Adapters.SportAdapter;
import com.daniel.sportsapp.Model.Sport;
import com.daniel.sportsapp.Presenters.MainActivityPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View, SportAdapter.OnItemClickListener {
    private RelativeLayout rlProgress;
    private RecyclerView rvSports;
    private MainActivityPresenter presenter;
    private SportAdapter sportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        setupView();
    }

    private void setupView(){
        rvSports = findViewById(R.id.rv_sports);
        rlProgress = findViewById(R.id.rl_progress);
        rlProgress.setVisibility(View.GONE);
        presenter.requestSports(getApplicationContext());
    }

    @Override
    public void showProgressDialog() {
        rlProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        rlProgress.setVisibility(View.GONE);
    }

    @Override
    public void setupSportsList(ArrayList<Sport> sports) {
        sportAdapter = new SportAdapter(sports,this);
        rvSports.setAdapter(sportAdapter);
        rvSports.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void goToSport(Sport sport) {
        Intent intent = new Intent(MainActivity.this, EventsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("sport", sport);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position) {
        Log.e("sportClicked",""+position);
        presenter.sportSelected(position);
    }
}
