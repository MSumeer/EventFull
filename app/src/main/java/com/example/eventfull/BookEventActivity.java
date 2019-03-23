package com.example.eventfull;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
            public void onClick(View view) {
                String eventName = etEventName.getText().toString().trim();
                String numberOfTickets = etNumberOfTickets.getText().toString().trim();

                //Create a JSONObject to store values
                try {
                    JSONObject obj = new JSONObject();
                    obj.put("Event",eventName);
                    obj.put("Tickets",numberOfTickets);

                    //Write JSONObject to file
                    File file = new File(getFilesDir()+"/Bookings.txt");
                    RandomAccessFile raf = new RandomAccessFile(file,"rw");
                    String line = "";
                    StringBuilder sb = new StringBuilder();
                    while((line=raf.readLine())!= null){
                        if(line.trim().equals("}")){
                            sb.append("},\n"+obj.toString(8)+"\n");
                        }else{
                            sb.append(line+"\n");
                        }
                    }
                    raf.seek(0);
                    raf.write(sb.toString().getBytes());


                    AlertDialog alertDialog = new AlertDialog.Builder(BookEventActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage(eventName+numberOfTickets);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                catch(JSONException e){
                    AlertDialog alertDialog = new AlertDialog.Builder(BookEventActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("ErrorJSON");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                catch(IOException e){
                    AlertDialog alertDialog = new AlertDialog.Builder(BookEventActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("ErrorIO");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }
        });
    }
}
