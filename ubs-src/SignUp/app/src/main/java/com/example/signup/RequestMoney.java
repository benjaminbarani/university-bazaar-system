package com.example.signup;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class RequestMoney extends AppCompatActivity {

    TextInputLayout username;
    TextInputLayout name;
    TextInputLayout amount;
    Button econfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_money);

        username = findViewById(R.id.textInputLayout4);
        name = findViewById(R.id.textInputLayout5);
        amount = findViewById(R.id.textInputLayout6);

        econfirm = findViewById(R.id.button5);


      econfirm.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String user = username.getEditText().getText().toString();
              String fullname = name.getEditText().getText().toString();

              if (user.isEmpty()) {
                  username.setError("Field is empty");

              }


              else if (fullname.isEmpty()) {
                  name.setError("Field is empty");

              }

              else{
                  String test_email = "benbarani@gmail.com";
                 String test_name = "Ben Barani";
                  if(user.equals(test_email)&&fullname.equals(test_name)){
                      //Toast.makeText(RequestMoney.this, "Request sent waiting for response...", Toast.LENGTH_SHORT).show();
                    alert("Waiting for response!!");
                  }
                  else{
                      Toast.makeText(com.example.signup.RequestMoney.this, "User doesnot exist", Toast.LENGTH_SHORT).show();

                  }
              }
          }
      });




    }
    private void alert(String message){
        AlertDialog dlg = new AlertDialog.Builder(com.example.signup.RequestMoney.this)
                .setTitle("Request Completed").setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent home_page = new Intent(com.example.signup.RequestMoney.this,Homepage.class);
                        startActivity(home_page);
                    }
                })
                .create();
        dlg.show();
    }
}
