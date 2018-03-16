package net.glm.goal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    TextView tvName;
    EditText weight;
    EditText height;
    EditText age;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);

      btn = findViewById(R.id.btnSignIn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this , LogInScreen.class);

       //    String s = weight.getText().toString();
       //    String s1 = height.getText().toString();
       //    String s2 = age.getText().toString();

      //    Double w = Double.valueOf(s);
      //    Double h = Double.valueOf(s1);
      //    Integer a = Integer.valueOf(s2);


        //  intent.putExtra("weight", w);
        //  intent.putExtra("height", h);
        //  intent.putExtra("age", a);
                startActivity(intent);

            }
        });

    }
}
