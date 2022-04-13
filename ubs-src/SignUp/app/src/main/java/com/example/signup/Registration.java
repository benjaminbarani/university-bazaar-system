 package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText Newname, NewEmail, NewPassword, NewUser, NewPhoneNumber;
    Button back, createCreate;
    FirebaseAuth fAuth;

   FirebaseFirestore fstore;
    String UserId;

    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        back = findViewById(R.id.Back);
        createCreate = findViewById(R.id.Create);
        Newname = (EditText) findViewById(R.id.Name);
        NewEmail = (EditText) findViewById(R.id.newEmail);
        NewPassword = (EditText) findViewById(R.id.newPassword);
        NewUser = (EditText) findViewById(R.id.newuser);
        NewPhoneNumber = (EditText) findViewById(R.id.PhoneNumber);

        dialog = new ProgressDialog(this);



        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), login.class));
            }
        });

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Homepage.class));
            finish();

        }

        //save data in Firebase
        createCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = Newname.getText().toString().trim();
                String email = NewEmail.getText().toString().trim();
                String password = NewPassword.getText().toString().trim();
                String username = NewUser.getText().toString().trim();
                String phone = NewPhoneNumber.getText().toString().trim();
                dialog.setMessage("Creating your account..");
                dialog.setCancelable(false);
                dialog.show();


                if (TextUtils.isEmpty(email)) {
                    NewEmail.setError("Email is Required");
                    dialog.dismiss();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    NewPassword.setError("Password is Required");
                    dialog.dismiss();
                    return;

                }

                if (password.length() < 6) {
                    NewPassword.setError("Password Must be at least 6 Characters");
                    dialog.dismiss();
                    return;
                }

                if (username.isEmpty()){
                    NewUser.setError("Username is Required");
                    dialog.dismiss();
                    return;
                }
                if (phone.isEmpty()){
                    NewPhoneNumber.setError("Phone number is required");
                    dialog.dismiss();
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            dialog.dismiss();
                            Toast.makeText(Registration.this, "User Created Succesfully", Toast.LENGTH_SHORT).show();
                            UserId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(UserId);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fName",name);
                            user.put("email",email);
                            user.put("phone",phone);
                            user.put("Username",username);
                            user.put("password", password);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    Log.d(TAG, "onSuccess: user Profile is created for "+ UserId);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Log.d(TAG, "onFailure: " + e.toString());

                                }
                            });
                            startActivity(new Intent(getApplicationContext(), Homepage.class));
                        } else {
                            Toast.makeText(Registration.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

    }
}

