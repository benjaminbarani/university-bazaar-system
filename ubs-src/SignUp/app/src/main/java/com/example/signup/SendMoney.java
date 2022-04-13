package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;


public class SendMoney extends AppCompatActivity {

    TextInputLayout username, amount, card_details, expiration, cvv;
    Button econfirm;

    FirebaseDatabase rootNode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);


        username = findViewById(R.id.textInputLayout);
        card_details = findViewById(R.id.textInputLayout3);
        amount = findViewById(R.id.textInputLayout2);
        expiration = findViewById(R.id.textInputLayout10);
        cvv = findViewById(R.id.textInputLayout11);
        econfirm = findViewById(R.id.btnSend);




        econfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameReceiver = username.getEditText().getText().toString();
                String cardNum = card_details.getEditText().getText().toString();


                  if (validateCard()||validateUser()||validatedb()) {

                      Intent fail_send = new Intent(com.example.signup.SendMoney.this, FailSend.class);
                      startActivity(fail_send);
                }
                    else {
                            Intent pass_send = new Intent(com.example.signup.SendMoney.this, PassSend.class);
                            startActivity(pass_send);
                            return;
                    }

                  }

        });
    }
private boolean validateCard(){
    String cardNum = card_details.getEditText().getText().toString();

    if(cardNum.length() < 16)      {
        return true;
    }

    return false;
}

    private boolean validateUser(){
        String usernameReceiver = username.getEditText().getText().toString();

        if(usernameReceiver.isEmpty()){
            return true;
        }

        return false;
    }

    private boolean validatedb(){
        String usernameReceiver = username.getEditText().getText().toString();
        String  namedb = "Mahdy@gmail.com";
        if(usernameReceiver.equals(namedb)){
            return false;
        }
        return true;

    }

}