package com.example.electrogoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chat extends AppCompatActivity {

    private Button chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chat = (Button)findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String url = "https://api.whatsapp.com/send?phone=6281312060752";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}