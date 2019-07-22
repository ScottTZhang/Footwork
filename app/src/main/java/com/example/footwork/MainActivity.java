package com.example.footwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button repsButton, timeButton, drillButton, punishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repsButton = findViewById(R.id.RepsButton);
        timeButton = findViewById(R.id.TimeButton);
        drillButton = findViewById(R.id.DrillButton);
        punishButton = findViewById(R.id.PunishButton);

        repsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //go to reps setting page
                startActivity(new Intent(MainActivity.this, RepsSettingsActivity.class));
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //go to reps setting page
                startActivity(new Intent(MainActivity.this, TimeSettingsActivity.class));
            }
        });

        punishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PunishSettingsActivity.class));
            }
        });

    }
}
