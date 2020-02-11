package com.example.footwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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
        StringBuilder text = new StringBuilder();

        intent = getIntent();

        //Can be null if no difficulty is selected.
        difficultyDetail = intent.getStringExtra("difficulty");
        text.append(difficultyDetail).append(":\n");
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        ArrayList<Drill> drillList = bundle.getParcelableArrayList("drillDetailList");

        assert drillList != null;
        for (Drill currentDrill : drillList) {
            text.append(currentDrill.title).append("\n").append(currentDrill.description).append("\n");
        }
        drillView.setText(text.toString());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "You are out of punishment.", Toast.LENGTH_LONG).show();
        this.finish();
    }
}
