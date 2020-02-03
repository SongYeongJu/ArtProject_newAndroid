package com.example.newartproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newartproject.R;

public class JoinActivity extends AppCompatActivity {
    private EditText emailTextView;
    private EditText pwTextView;
    private EditText checkPwTextView;

    private Button joinButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        emailTextView=(EditText)findViewById(R.id.joinEmailEditText);
        pwTextView=(EditText)findViewById(R.id.joinPwEditText);
        checkPwTextView=(EditText)findViewById(R.id.joinCheckPwEditText);

        joinButton=(Button)findViewById(R.id.JoinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(JoinActivity.this, CheckTasteActivity.class);
                startActivity(intent2);
                finish();

                String email=emailTextView.getText().toString();
                if(email.contains("@") && email.contains(".")) {
                    if(pwTextView.toString().length()<8) {
                        Toast.makeText(JoinActivity.this,"pw length should be more than 8",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(pwTextView.toString().equals(checkPwTextView.getText().toString())) {
                        Intent intent = new Intent(JoinActivity.this, CheckTasteActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
//                        Toast.makeText(JoinActivity.this,"pw and pw-check are not same",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(JoinActivity.this,"email is invalid",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
