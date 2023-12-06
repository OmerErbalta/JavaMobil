package com.example.javamobil_vize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_view);
        Button sendBtn = findViewById(R.id.sendBtn);
        EditText phone = findViewById(R.id.phoneNumber);
        EditText messageInput = findViewById(R.id.message);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phone.getText().toString();
                String message = messageInput.getText().toString();

                if(!phoneNumber.isEmpty() && !message.isEmpty()){
                    SmsManager smsManager = SmsManager.getDefault();

                    smsManager.sendTextMessage(phoneNumber,null,message,null,null);
                }
                else{
                    //mesaj göndermicek
                }

            }
        });


    }
}