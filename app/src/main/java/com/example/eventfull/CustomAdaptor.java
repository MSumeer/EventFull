package com.example.eventfull;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter {
    ArrayList<Event> event = null;
    ArrayList<Ticket> tickets = null;
    Context context;
    LayoutInflater inflter;
    String value;

    public CustomAdaptor(Context context, ArrayList<Event> event, ArrayList <Ticket> tickets) {
        this.context = context;
        this.event = event;
        this.tickets = tickets;
        inflter = (LayoutInflater.from(context));

    }

    @Override
    public int getCount() {
        return tickets.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = View.inflate(context,R.layout.list_items,null);
        final CheckBox simpleCheckBox= view.findViewById(R.id.checkBox2);
        simpleCheckBox.setText(event.get(position).getName());
// perform on Click Event Listener on CheckedTextView
        simpleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (simpleCheckBox.isChecked()) {
// set cheek mark drawable and set checked property to false
                    value = "un-Checked";
                    simpleCheckBox.setChecked(false);
                } else {
// set cheek mark drawable and set checked property to true
                    value = "Checked";
                    simpleCheckBox.setChecked(true);
                }
                Toast.makeText(context, value, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}

