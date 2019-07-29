package com.example.footwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class PunishSettingsActivity extends Activity {

    Button confirmPunishButton;
    Button clearSelectionButton;

    GridView drillGridView;
    //Hard coded as 12. Needs to pass the value to values folder, and use
    private Integer[] questionImages = {
            R.drawable.question, R.drawable.question,
            R.drawable.question, R.drawable.question,
            R.drawable.question, R.drawable.question,
            R.drawable.question, R.drawable.question,
            R.drawable.question, R.drawable.question,
            R.drawable.question, R.drawable.question};

    String[] gridViewString = {
            "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punish_settings);

        //Display the drill gridview
        DrillAdapter drillAdapter = new DrillAdapter(getApplicationContext(), gridViewString, questionImages);
        drillGridView = findViewById(R.id.DrillGrid);
        drillGridView.setAdapter(drillAdapter);

        drillGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                View textView = view.findViewById(R.id.drill_gridview_text);
                textView.setVisibility(View.VISIBLE);
                View imageView = view.findViewById(R.id.drill_gridview_image);
                imageView.setVisibility(View.INVISIBLE);

                // set an Intent to Another Activity
                Intent intent = new Intent(PunishSettingsActivity.this, PunishDetailsActivity.class);
                intent.putExtra("title", gridViewString[position]); // put image data in Intent

                Toast.makeText(PunishSettingsActivity.this, "added", Toast.LENGTH_LONG).show();
            }
        });

        //Display the difficulty gridview
        GridView difficultyGridView = findViewById(R.id.DifficultyGrid);
        difficultyGridView.setAdapter(new DifficultyAdapter(this));
        difficultyGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                View imageView = v.findViewById(R.id.drill_gridview_image);
                imageView.setVisibility(View.INVISIBLE);
                Toast.makeText(PunishSettingsActivity.this, "Image Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
