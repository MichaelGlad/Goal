package net.glm.goal;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //UI Members
    TextView goalsTV;
    TextView leaderboardsTV;
    TextView tryoutsTV;
    TextView caloriesTV;
    ProgressBar progressBar;
    Button btnMapActivity;

    private RecyclerView recyclerView;
    private ArrayList<Challenge> challenges;
    private ChallengesAdapter challengesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        challenges = new ArrayList<>();
        for (int i = 0; i< 5; i++){
            challenges.add(new Challenge("sss"));
        }
        challengesAdapter = new ChallengesAdapter(challenges);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(challengesAdapter);


        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        bindViewToMembers();
        setFakeData();

    }

    private void bindViewToMembers(){
        goalsTV= findViewById(R.id.goals_tv);
        leaderboardsTV= findViewById(R.id.leaderboards_tv);
        tryoutsTV= findViewById(R.id.tryouts_tv);
        caloriesTV= findViewById(R.id.calories_tv);
        progressBar = findViewById(R.id.progressBar2);
        btnMapActivity = findViewById(R.id.btn_map_activity);
        btnMapActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btn_map_activity){
                    Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void setFakeData(){

        goalsTV.setText("58%");
        leaderboardsTV.setText("39th");
        tryoutsTV.setText("5 times");
        caloriesTV.setText("786 cal");
        progressBar.setProgress(50);
    }

}
