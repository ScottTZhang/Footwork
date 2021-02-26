package com.example.footwork;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class DrillSelectActivity extends AppCompatActivity {

    // lfh - left front high, lml - left mid loe
    CheckBox lfh, lfl, lmh, lml, lbh, lbl, rfh, rfl, rmh, rml, rbh, rbl;
    TextView drillText;
    ArrayList<String> drillList = new ArrayList<>();
    Switch randomSwitch;
    Button playDrillButton;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_select);

        //hide action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        //Toast to select a drill
        Toast.makeText(getApplicationContext(), "Please add at least a drill.", Toast.LENGTH_LONG).show();

        lfh = findViewById(R.id.leftFrontHigh);
        lfl = findViewById(R.id.leftFrontLow);
        lmh = findViewById(R.id.leftMidHigh);
        lml = findViewById(R.id.leftMidLow);
        lbh = findViewById(R.id.leftBackHigh);
        lbl = findViewById(R.id.leftBackLow);
        rfh = findViewById(R.id.rightFrontHigh);
        rfl = findViewById(R.id.rightFrontLow);
        rmh = findViewById(R.id.rightMidHigh);
        rml = findViewById(R.id.rightMidLow);
        rbh = findViewById(R.id.rightBackHigh);
        rbl = findViewById(R.id.rightBackLow);
        drillText = findViewById(R.id.drillList);
        randomSwitch = findViewById(R.id.randomSwitch);
        playDrillButton = findViewById(R.id.drillButton);

        lfh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lfh.isChecked()) {
                    drillList.add("lfh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("lfh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        lfl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lfl.isChecked()) {
                    drillList.add("lfl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("lfl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        lml.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lml.isChecked()) {
                    drillList.add("lml");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                    System.out.println(R.string.drills_colon);
                } else {
                    drillList.remove("lml");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        lmh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lmh.isChecked()) {
                    drillList.add("lmh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("lmh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        lbl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lbl.isChecked()) {
                    drillList.add("lbl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("lbl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        lbh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lbh.isChecked()) {
                    drillList.add("lbh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("lbh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        rfl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rfl.isChecked()) {
                    drillList.add("rfl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("rfl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        rfh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rfh.isChecked()) {
                    drillList.add("rfh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("rfh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        rml.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rml.isChecked()) {
                    drillList.add("rml");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("rml");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        rmh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rmh.isChecked()) {
                    drillList.add("rmh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("rmh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        rbl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rbl.isChecked()) {
                    drillList.add("rbl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("rbl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        rbh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rbh.isChecked()) {
                    drillList.add("rbh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("rbh");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        lfl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lfl.isChecked()) {
                    drillList.add("lfl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("lfl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        lfl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (lfl.isChecked()) {
                    drillList.add("lfl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                } else {
                    drillList.remove("lfl");
                    drillText.setText(getString(R.string.drills_colon, drillList));
                }
            }
        });

        playDrillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Prompt if drill or difficulty is not selected
                if (drillList.size() == 0) {
                    AlertDialog alertDialog = new AlertDialog.Builder(DrillSelectActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You must select at least one drill.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    i = new Intent(DrillSelectActivity.this, FaceTrackerActivity.class);
                    i.putExtra("drillList", drillList);
                    i.putExtra("randomDrill", randomSwitch.isChecked());
                    startActivity(i);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "Please select a mode.", Toast.LENGTH_LONG).show();
        this.finish();
    }
}
