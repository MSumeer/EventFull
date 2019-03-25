package com.example.eventfull;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StaffActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_staff);

        Button btnAddEvent = findViewById(R.id.buttonAddEvent);
        Button btnEditEvent = findViewById(R.id.buttonEditEvent);
        Button btnContinue = findViewById(R.id.buttonContinue);

        btnAddEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(StaffActivity.this,AddEventActivity.class);
                startActivity(intent);
            }
        });
        btnEditEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(StaffActivity.this,EditEventActivity.class);
                //startActivity(intent);
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(StaffActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
