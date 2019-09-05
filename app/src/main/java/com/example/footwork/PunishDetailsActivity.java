package com.example.footwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;


public class PunishDetailsActivity extends Activity {

    Intent intent;
    TextView drillView;
    String difficultyDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_punishment);

        drillView = findViewById(R.id.DrillTextView);
        String text = "";

        intent = getIntent();

        //Can be null if no difficulty is selected.
        difficultyDetail = intent.getStringExtra("difficulty");
        text += difficultyDetail + ":\n";
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        ArrayList<Drill> drillList = bundle.getParcelableArrayList("drillDetailList");

        assert drillList != null;
        for (Drill currentDrill : drillList) {
            text += currentDrill.title + "\n" + currentDrill.description + "\n";
        }
        drillView.setText(text);
    }
}
