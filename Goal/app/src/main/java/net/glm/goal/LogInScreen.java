package net.glm.goal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LogInScreen extends AppCompatActivity {

    ArrayList<Level> levels = new ArrayList<>();
    RecyclerView recyclerView;
    TextView tvtxt;
    TextView weight;
    TextView height;
    TextView age;
    Button btnLetsGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);


        weight = findViewById(R.id.weight22);
        height = findViewById(R.id.height22);
        age = findViewById(R.id.age22);
        btnLetsGo = findViewById(R.id.btn_lets_go);

        tvtxt = findViewById(R.id.tvTxt);
        recyclerView = findViewById(R.id.levelsRecyclerView);

    //  Intent intent = getIntent();
    //  String weight1 = intent.getStringExtra("weight");
    //  String height1 = intent.getStringExtra("height");
    //  String age1 = intent.getStringExtra("age");
        //weight.setText(weight1);
        //height.setText(height1);
        //age.setText(age1);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String weight = sharedPref.getString("weight",null);
        String height = sharedPref.getString("height",null);

        levels.add(new Level("1Km"));
        levels.add(new Level("3Km"));
        levels.add(new Level("5Km"));
        levels.add(new Level("10Km"));

        LevelAdapter adapter = new LevelAdapter(levels , this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        btnLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInScreen.this , MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
