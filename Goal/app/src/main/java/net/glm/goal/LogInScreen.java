package net.glm.goal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LogInScreen extends AppCompatActivity {

    ArrayList<Level> levels = new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        recyclerView = findViewById(R.id.levelsRecyclerView);

        levels.add(new Level("ok"));
        levels.add(new Level("ok1"));
        levels.add(new Level("ok2"));
        levels.add(new Level("ok3"));

        LevelAdapter adapter = new LevelAdapter(levels , this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
