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

public class RepsSettingsActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Button playRepsButton;
    Intent i;
    String repItem, breakItem, setItem, startItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reps_settings);

        Spinner spinner = findViewById(R.id.repsSpinner);
        Spinner spinnerBreak = findViewById(R.id.breakSpinner);
        Spinner spinnerSet = findViewById(R.id.setsSpinner);
        Spinner spinnerStart = findViewById(R.id.startSpinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.reps_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterBreak = ArrayAdapter.createFromResource(this,
                R.array.break_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterSet = ArrayAdapter.createFromResource(this,
                R.array.set_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterStart = ArrayAdapter.createFromResource(this,
                R.array.start_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterBreak.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterSet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterStart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(this);

        spinnerBreak.setAdapter(adapterBreak);
        spinnerBreak.setSelection(0);
        spinnerBreak.setOnItemSelectedListener(this);

        spinnerSet.setAdapter(adapterSet);
        spinnerSet.setSelection(0);
        spinnerSet.setOnItemSelectedListener(this);

        spinnerStart.setAdapter(adapterStart);
        spinnerStart.setSelection(0);
        spinnerStart.setOnItemSelectedListener(this);

        playRepsButton = findViewById(R.id.RepsStartButton);
        playRepsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                i = new Intent(RepsSettingsActivity.this, PlayRepsActivity.class);
                i.putExtra("repsNumber",repItem);
                i.putExtra("breakNumber", breakItem);
                i.putExtra("setNumber", setItem);
                i.putExtra("startNumber", startItem);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        if (parent.getId() == R.id.repsSpinner) {
            repItem = parent.getItemAtPosition(pos).toString();
        }
        if (parent.getId() == R.id.breakSpinner) {
            breakItem = parent.getItemAtPosition(pos).toString();
        }
        if (parent.getId() == R.id.setsSpinner) {
            setItem = parent.getItemAtPosition(pos).toString();
        }
        if (parent.getId() == R.id.startSpinner) {
            startItem = parent.getItemAtPosition(pos).toString();
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "Please select a mode.", Toast.LENGTH_LONG).show();
        this.finish();
    }
}
