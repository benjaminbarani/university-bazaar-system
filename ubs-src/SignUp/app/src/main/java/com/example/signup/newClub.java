package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class newClub extends AppCompatActivity {


    public static final String TAG = "TAG";
    Button bt1;
    EditText cname, Creason, Cnum;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String club;
    FirebaseUser ClubUser;


//returning
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_club);

      bt1 = findViewById(R.id.Cbtn);
      cname = findViewById(R.id.cname);
      Creason = findViewById(R.id.Creason);
      Cnum = findViewById(R.id.Cnum);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = cname.getText().toString().trim();
                String reason = Creason.getText().toString().trim();
                String number = Cnum.getText().toString().trim();

            }
        });
    }
}