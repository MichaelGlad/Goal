package net.glm.goal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LogInScreen extends AppCompatActivity {

    ArrayList<Level> levels = new ArrayList<>();
    RecyclerView recyclerView;
    TextView tvtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        tvtxt = findViewById(R.id.tvTxt);
        recyclerView = findViewById(R.id.levelsRecyclerView);

        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        tvtxt.setText(user);


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
