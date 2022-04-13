package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PassSend extends AppCompatActivity {

    Button ebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_send);

        ebutton = findViewById(R.id.button4);

        ebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent home_page = new Intent(com.example.signup.PassSend.this,Homepage.class);
                startActivity(home_page);
            }
        });
    }
}