package net.glm.goal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    TextView tvName;
    EditText etUserName;
    EditText etPassword;
    EditText etEmail;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

      btn = findViewById(R.id.btnSignIn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this , LogInScreen.class);
                String getuser = etUserName.getText().toString();
                String s = String.valueOf(getuser);
                intent.putExtra("user", s);
                startActivity(intent);

            }
        });

    }
}
