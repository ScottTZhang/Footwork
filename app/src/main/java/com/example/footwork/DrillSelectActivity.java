package com.example.footwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class DrillSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_select);
        //hide action bar
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}
