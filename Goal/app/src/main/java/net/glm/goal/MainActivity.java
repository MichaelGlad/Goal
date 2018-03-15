package net.glm.goal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMapActivity;
    Button btnLoginActivity;
    Button btnStartUpActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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




}
