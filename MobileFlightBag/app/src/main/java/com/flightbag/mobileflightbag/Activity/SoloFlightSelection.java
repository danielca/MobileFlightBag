package com.flightbag.mobileflightbag.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightbag.mobileflightbag.Adapter.CheckListAdapter;
import com.flightbag.mobileflightbag.Model.CheckListItem;
import com.flightbag.mobileflightbag.Util.JsonLoader;
import com.flightbag.mobileflightbag.R;

import java.io.IOException;
import java.util.Arrays;

public class SoloFlightSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_flight_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ObjectMapper objectMapper = new ObjectMapper();
        CheckListItem[] checkListItems = null;
        try {
            String jsonString = JsonLoader.loadJSONFromAsset("solo.json", getApplicationContext());
            if (jsonString != null){
                checkListItems = objectMapper.readValue(jsonString.getBytes(), CheckListItem[].class);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        if (checkListItems != null) {
            ListView listView = (ListView) findViewById(R.id.solo_list_view);
            CheckListAdapter checkListAdapter = new CheckListAdapter(this, Arrays.asList(checkListItems));
            assert listView != null;
            listView.setAdapter(checkListAdapter);

        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



}
