package com.example.footwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class TimeSettingsActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Button playTimeButton;
    Intent i;
    String timeSets, timeBreak, timeDown, setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_settings);

        Spinner timeSetsSpinner = findViewById(R.id.time_sets_spinner);
        ArrayAdapter<CharSequence> setsAdapter = ArrayAdapter.createFromResource(this,
                R.array.time_sets_array, android.R.layout.simple_spinner_item);
        setsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSetsSpinner.setAdapter(setsAdapter);
        timeSetsSpinner.setSelection(0);
        timeSetsSpinner.setOnItemSelectedListener(this);

        Spinner setTimeSpinner = findViewById(R.id.set_Time_Spinner);
        ArrayAdapter<CharSequence> timeAdapter = ArrayAdapter.createFromResource(this,
                R.array.set_time_array, android.R.layout.simple_spinner_item);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setTimeSpinner.setAdapter(timeAdapter);
        setTimeSpinner.setSelection(0);
        setTimeSpinner.setOnItemSelectedListener(this);

        Spinner timeBreakSpinner = findViewById(R.id.time_break_spinner);
        ArrayAdapter<CharSequence> breakAdapter = ArrayAdapter.createFromResource(this,
                R.array.time_break_array, android.R.layout.simple_spinner_item);
        breakAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeBreakSpinner.setAdapter(breakAdapter);
        timeBreakSpinner.setSelection(0);
        timeBreakSpinner.setOnItemSelectedListener(this);

        Spinner timeDownSpinner = findViewById(R.id.time_countdown_spinner);
        ArrayAdapter<CharSequence> downAdapter = ArrayAdapter.createFromResource(this,
                R.array.time_start_array, android.R.layout.simple_spinner_item);
        downAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeDownSpinner.setAdapter(downAdapter);
        timeDownSpinner.setSelection(0);
        timeDownSpinner.setOnItemSelectedListener(this);

        playTimeButton = findViewById(R.id.TimeStartButton);
        playTimeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                i = new Intent(TimeSettingsActivity.this, PlayTimeActivity.class);
                i.putExtra("timeSets", timeSets);
                i.putExtra("setTime", setTime);
                i.putExtra("timeBreak", timeBreak);
                i.putExtra("timeDown", timeDown);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.time_sets_spinner) {
            timeSets = parent.getItemAtPosition(position).toString();
        }
        if (parent.getId() == R.id.set_Time_Spinner) {
            setTime = parent.getItemAtPosition(position).toString();
        }
        if (parent.getId() == R.id.time_break_spinner) {
            timeBreak = parent.getItemAtPosition(position).toString();
        }
        if (parent.getId() == R.id.time_countdown_spinner) {
            timeDown = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "Please select a mode.", Toast.LENGTH_LONG).show();
        this.finish();
    }
}
