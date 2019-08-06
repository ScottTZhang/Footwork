package com.example.footwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PunishSettingsActivity extends Activity {

    Button confirmPunishButton;
    Button clearSelectionButton;

    GridView drillGridView;
    //Hard coded as 12. Needs to pass the value to values folder, and use


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punish_settings);

        confirmPunishButton = findViewById(R.id.PunishConfirmButton);
        confirmPunishButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                return true;
            }
        });

        //Display the drill gridview
        //initialize the drill List
        List<Drill> drills = new ArrayList<>();
        List<String> drillTitles = Arrays.asList(getResources().getStringArray(R.array.drill_title_array));
        List<String> drillDescriptions = Arrays.asList(getResources().getStringArray(R.array.drill_explanation_array));
        for (int index = 0; index < 10; index++) {
            String title = drillTitles.get(index);
            String description = drillDescriptions.get(index);
            Drill curr = new Drill(title, description, R.drawable.question);
            drills.add(curr);
        }

        //shuffle the drill List
        Collections.shuffle(drills);

        //convert drill List to Array
        final Drill[] drillsArray = drills.toArray(new Drill[0]);

        //Display the drill gridview
        DrillAdapter drillAdapter = new DrillAdapter(getApplicationContext(), drillsArray);
        drillGridView = findViewById(R.id.DrillGrid);
        drillGridView.setAdapter(drillAdapter);

        drillGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Hide the question and display the title.
                View textView = view.findViewById(R.id.gridview_text);
                textView.setVisibility(View.VISIBLE);
                View imageView = view.findViewById(R.id.gridview_image);
                imageView.setVisibility(View.INVISIBLE);

                // set an Intent to Another Activity
                Intent intent = new Intent(PunishSettingsActivity.this, PunishDetailsActivity.class);
                String selectedDrillTitle = drillsArray[position].title;
                intent.putExtra("title", selectedDrillTitle); // put image data in Intent

                Toast.makeText(PunishSettingsActivity.this, selectedDrillTitle + " is added.", Toast.LENGTH_LONG).show();
            }
        });


        //Display the difficulty gridview
        //initialize the difficulty List
        List<Difficulty> difficulties = new ArrayList<>();
        List<String> difficultyLevels = Arrays.asList(getResources().getStringArray(R.array.difficulty_title_array));
        for (int index = 0; index < difficultyLevels.size(); index++) {
            String level = difficultyLevels.get(index);
            Difficulty curr = new Difficulty(level, R.drawable.question);
            difficulties.add(curr);
        }

        //shuffle the difficulty List
        Collections.shuffle(difficulties);

        //convert difficulty List to Array
        final Difficulty[] difficultiesArray = difficulties.toArray(new Difficulty[0]);

        //Display the difficulty gridview
        DifficultyAdapter difficultyAdapter = new DifficultyAdapter(getApplicationContext(), difficultiesArray);
        GridView difficultyGridView = findViewById(R.id.DifficultyGrid);
        difficultyGridView.setAdapter(difficultyAdapter);

        difficultyGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                View textView = view.findViewById(R.id.gridview_text);
                textView.setVisibility(View.VISIBLE);
                View imageView = view.findViewById(R.id.gridview_image);
                imageView.setVisibility(View.INVISIBLE);
                view.setClickable(false);

                // set an Intent to Another Activity
                Intent intent = new Intent(PunishSettingsActivity.this, PunishDetailsActivity.class);
                String selectedDifficultyLevel = difficultiesArray[position].level;
                intent.putExtra("difficulty", selectedDifficultyLevel); // put difficulty data in Intent
                Toast.makeText(PunishSettingsActivity.this, "Difficulty: " + selectedDifficultyLevel, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
