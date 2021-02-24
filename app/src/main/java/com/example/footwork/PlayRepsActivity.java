package com.example.footwork;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;


public class PlayRepsActivity extends AppCompatActivity {

    Intent intent;
    String reps, breakTime, sets, start;
    long MillisecondTime, StartTime;
    Handler handler;
    int Seconds, Minutes, MilliSeconds;
    TextView timer;
    int repsInt, breakInt, setsInt, startInt;
    int updateRepsInt, updateSetsInt;
    TextView repsDownView;
    CountDownTimer workoutTimer;
    TextView ready;
    ArrayList<String> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_reps);
        Objects.requireNonNull(getSupportActionBar()).hide();

        intent = getIntent();

        reps = intent.getStringExtra("repsNumber");
        breakTime = intent.getStringExtra("breakNumber");
        sets = intent.getStringExtra("setNumber");
        start = intent.getStringExtra("startNumber");

        repsInt = Integer.parseInt(reps);
        updateRepsInt = repsInt;
        breakInt = Integer.parseInt(breakTime);
        setsInt = Integer.parseInt(sets);
        updateSetsInt = setsInt;
        startInt = Integer.parseInt(start);
        handler = new Handler();
        timer = findViewById(R.id.timerView);
        result = new ArrayList<>();

        ready = findViewById(R.id.RepsReadyTextView);
        repsDownView = findViewById(R.id.RepsDownView);
        repsDownView.setText(String.valueOf(updateRepsInt));

        startRepsTimer(startInt * 1000);
    }

    public void startRepsTimer(int startTimer) {
        workoutTimer = new CountDownTimer(startTimer, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                ready.setText(String.valueOf(1 + millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                //start timing
                StartTime = SystemClock.uptimeMillis();
                //display the time used
                handler.postDelayed(runnable, 0);
                ready.setText("Go!");
                repsDownView.setClickable(true);
                repsDownView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String currentReps = String.valueOf(repsDownView.getText());
                        updateRepsInt = Integer.parseInt(currentReps);
                        updateRepsInt--;
                        repsDownView.setText(String.valueOf(updateRepsInt));

                        if (updateRepsInt == 0) {
                            updateSetsInt--;
                            result.add((String) timer.getText());
                            repsDownView.setClickable(false);
                            if (updateSetsInt == 0) {
                                ready.setText("Break!");
                                Toast.makeText(getApplicationContext(), "Sets finished.\n" + result, Toast.LENGTH_LONG).show();
                                //reset timer to time next set
                                handler.removeCallbacks(runnable);
                                workoutTimer.cancel();
                            } else {
                                Toast.makeText(getApplicationContext(), "Sets left: " + updateSetsInt, Toast.LENGTH_LONG).show();
                                updateRepsInt = repsInt;
                                repsDownView.setText(String.format("%d", updateRepsInt));
                                //reset timer to time next set
                                handler.removeCallbacks(runnable);
                                startRepsTimer(breakInt * 1000);
                            }
                        }
                    }
                });
            }
        };
        workoutTimer.start();
    }

    public Runnable runnable = new Runnable() {
        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            Seconds = (int) (MillisecondTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (MillisecondTime % 100);

            timer.setText(String.format("%d:%s\"%s", Minutes, String.format("%02d", Seconds), String.format("%02d", MilliSeconds)));

            handler.postDelayed(this, 0);
        }
    };


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "Drill has stopped.\n" + result, Toast.LENGTH_LONG).show();
        this.finish();
    }

}
