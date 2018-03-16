package net.glm.goal;


import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements changeBackground {

    private RecyclerView recyclerView;
    private ArrayList<Challenge> challenges;
    private ChallengesAdapter challengesAdapter;

    @Override
    public void changeBackground(int backgroundNumber) {
        ConstraintLayout layout =findViewById(R.id.mainView);
        layout.setBackgroundResource(R.drawable.gradient_background);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        challenges = new ArrayList<>();
        for (int i = 0; i< 5; i++){
            challenges.add(new Challenge("sss"));
        }
        challengesAdapter = new ChallengesAdapter(challenges, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(challengesAdapter);




        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);


    }


}
