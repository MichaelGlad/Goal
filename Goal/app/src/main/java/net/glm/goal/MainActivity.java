package net.glm.goal;


import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Challenge> challenges;
    private ChallengesAdapter challengesAdapter;
    LinearLayoutManager layoutManager;


    public void changeBackground(int backgroundNumber) {
        ConstraintLayout layout =findViewById(R.id.mainView);
        ImageView imageView = findViewById(R.id.challenge_image);
        Log.e("position", String.valueOf(backgroundNumber));
        switch (backgroundNumber){
            case 0:
                layout.setAlpha((float) 1);
                layout.setBackgroundResource(R.drawable.orange_gradient);
                imageView.setImageResource(R.drawable.challenge1k);
                break;
            case 1:
                layout.setAlpha((float) 1);
                layout.setBackgroundResource(R.drawable.gradient_3k);
                imageView.setImageResource(R.drawable.challenge3k);
                break;
            case 2:
                layout.setAlpha((float) 1);
                layout.setBackgroundResource(R.drawable.gradient_background);
                imageView.setImageResource(R.drawable.challenge5k);
                break;
            case 3:
                layout.setAlpha((float) 1);
                layout.setBackgroundResource(R.drawable.gradient_10k);
                imageView.setImageResource(R.drawable.challenge10k);
                break;
            case -1:
                layout.setAlpha((float) 1);

                break;
            default:
                layout.setAlpha((float) 1);
                layout.setBackgroundResource(R.drawable.gradient_background);


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        challenges = new ArrayList<>();
        for (int i = 0; i< 4; i++){
            challenges.add(new Challenge(String.valueOf(i),String.valueOf(50+i),"22th","2",String.valueOf(70), "4 days left",
                    "2h", "80Km", String.valueOf(5)));
        }
        challengesAdapter = new ChallengesAdapter(challenges);
         layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(challengesAdapter);

        recyclerView.addOnScrollListener(mScrollListener);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);


    }
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            changeBackground(layoutManager.findFirstCompletelyVisibleItemPosition());

        }
    };
}
