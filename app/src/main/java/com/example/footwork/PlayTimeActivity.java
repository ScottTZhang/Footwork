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

public class PlayTimeActivity extends AppCompatActivity {

    Intent intent;
    String sets, setTime, breakTime, countDown;
    int setsInt, setTimeInt, breakTimeInt, countDownInt, startInt;
    ArrayList<String> result;
    int updatedRep;

    Handler handler;

    //for stop watch countdown
    long MillisecondTime, FinishTime;
    TextView timer;
    TextView ready;
    TextView countRepsView;
    CountDownTimer workoutTimer, restTimer;
    int Seconds, Minutes, MilliSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_time);

        intent = getIntent();

        sets = intent.getStringExtra("timeSets");
        setTime = intent.getStringExtra("setTime");
        breakTime = intent.getStringExtra("timeBreak");
        countDown = intent.getStringExtra("timeDown");

        setsInt = Integer.parseInt(sets);
        setTimeInt = Integer.parseInt(setTime);
        breakTimeInt = Integer.parseInt(breakTime);
        countDownInt = Integer.parseInt(countDown);
        startInt = 0;

        handler = new Handler();

        timer = findViewById(R.id.timePlayView);
        ready = findViewById(R.id.timeDownView);
        countRepsView = findViewById(R.id.countRepsView);

        countRepsView.setClickable(false);
        result = new ArrayList<>();


        rest(0);
    }

    public void rest(final int setIndex) {
        if (setIndex == 0) {
            startInt = (countDownInt) * 1000;
        } else {
            startInt = (breakTimeInt) * 1000;
        }
        restTimer = new CountDownTimer(startInt, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                ready.setText(String.valueOf(1 + millisUntilFinished / 1000));
                timer.setText("00:00:00");
            }

            @Override
            public void onFinish() {
                if(setIndex != setsInt){
                    workout(setIndex + 1);
                }
            }
        };
        restTimer.start();
    }

    public void workout(final int setIndex) {
        FinishTime = SystemClock.uptimeMillis() + setTimeInt * 1000;
        workoutTimer = new CountDownTimer(setTimeInt * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                ready.setText("Go!");
                handler.postDelayed(runnable, 0);
                countRepsView.setClickable(true);
                countRepsView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String currentRep = String.valueOf(countRepsView.getText());
                        updatedRep = Integer.parseInt(currentRep);
                        updatedRep++;
                        countRepsView.setText(String.valueOf(updatedRep));
                    }
                });
            }

            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);
                result.add(String.valueOf(countRepsView.getText()));
                countRepsView.setClickable(false);
                countRepsView.setText("0");
                if (setIndex != setsInt) {
                    rest(setIndex);
                } else {
                    ready.setText("Break!");
                    timer.setText("00:00:00");
                    restTimer.cancel();
                    workoutTimer.cancel();
                    Toast.makeText(getApplicationContext(), "Result: " + result, Toast.LENGTH_LONG).show();
                }
            }
        };
        workoutTimer.start();
    }


    public Runnable runnable = new Runnable() {
        public void run() {

            MillisecondTime = FinishTime - SystemClock.uptimeMillis();

            Seconds = (int) (MillisecondTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (MillisecondTime % 100);

            timer.setText("" + Minutes + ":" + String.format("%02d", Seconds) + ":" + String.format("%02d", MilliSeconds));

            handler.postDelayed(this, 0);
        }
    };
}
