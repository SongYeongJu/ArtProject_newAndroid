package com.example.newartproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.newartproject.R;

public class Login1Activity extends AppCompatActivity {
    private Button loginButton;
    private Button joinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        loginButton=(Button)findViewById(R.id.gotoLoginButton);
        joinButton=(Button)findViewById(R.id.gotoJoinButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login1Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login1Activity.this,JoinActivity.class);
                startActivity(intent);
            }
        });
    }
}
