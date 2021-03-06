package com.example.ganeshtikone.componets;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {


    private TextView textViewInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initUI();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Init UI and Get Data From Intent
     */
    private void initUI() {

        textViewInfo = findViewById(R.id.textViewInfo);

        // Data get

        Intent intent = getIntent();

        if (null != intent){

            Bundle bundle = intent.getExtras();

            // FName,mName,lName,Mobile

            String fName = bundle.getString("first_name");
            String mName = bundle.getString("middle_name");
            String lName = bundle.getString("last_name");
            String mobile = bundle.getString("mobile");

            String result = fName + " " + mName + " " + lName + " " +mobile;

            textViewInfo.setText(result);
        }


    }

}
