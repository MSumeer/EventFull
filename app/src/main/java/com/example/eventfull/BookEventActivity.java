package com.example.eventfull;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BookEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_event);

        final TextView tvTotal = findViewById(R.id.tvTotal);
        final EditText etEventName = findViewById(R.id.etEventName);
        final EditText etNumberOfTickets = findViewById(R.id.etNumberOfTickets);
        final Button btnUpdatePrice = findViewById(R.id.btnUpdatePrice);
        final Button btnBook = findViewById(R.id.btnBook);


        btnUpdatePrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final int x = Integer.parseInt(etNumberOfTickets.getText().toString());
                    tvTotal.setText("TOTAL : " + 10*x);
                }catch (NumberFormatException e){

                }

            }
        });



        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(BookEventActivity.this,PaymentActivity.class);
                startActivity(a);
            }
        });


    }
}
