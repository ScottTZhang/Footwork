package com.example.footwork;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class PunishSettingsActivity extends Activity {

    Button confirmPunishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punish_settings);
    }
}