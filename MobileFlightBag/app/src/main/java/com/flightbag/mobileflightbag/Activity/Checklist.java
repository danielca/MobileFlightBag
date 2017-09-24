package com.flightbag.mobileflightbag.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightbag.mobileflightbag.Adapter.CheckListAdapter;
import com.flightbag.mobileflightbag.Model.CheckListItem;
import com.flightbag.mobileflightbag.R;
import com.flightbag.mobileflightbag.Util.JsonLoader;

import java.io.IOException;
import java.util.Arrays;

public class Checklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ObjectMapper objectMapper = new ObjectMapper();

        CheckListItem[] checklistItem = null;

        try {
            String jsonString = JsonLoader.loadJSONFromAsset("solo.json", getApplicationContext());
            if (jsonString != null){
                checklistItem = objectMapper.readValue(jsonString.getBytes(), CheckListItem[].class);
//                checkListSelectionItems = objectMapper.readValue(jsonString.getBytes(), CheckListSelectionItem[].class);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        if (checklistItem != null){
            ListView listView = (ListView) findViewById(R.id.checklist_listView);
            CheckListAdapter checkListAdapter = new CheckListAdapter(getApplicationContext(), Arrays.asList(checklistItem));
            assert listView != null;
            listView.setAdapter(checkListAdapter);
        }


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        assert fab != null;
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
