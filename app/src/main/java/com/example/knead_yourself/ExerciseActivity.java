package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {
    TextView title;
    TextView description;
    TextView score;
    TableExercise tb;
    Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        this.title = findViewById(R.id.title1);
        this.description = findViewById(R.id.discription);
        this.score = findViewById(R.id.score);
        this.cont = findViewById(R.id.cont);
        //Intent intent = getIntent();
        //long idGet = Integer.parseInt(intent.getStringExtra("idTrainings"));
        //Exercise exercise = tb.select(idGet);
        //title.setText(exercise.getName());
        //description.setText(exercise.getDescription());
        //score.setText(exercise.getScore());
    }
}
