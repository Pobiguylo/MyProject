package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class ExerciseActivity extends AppCompatActivity {
    TextView title;
    TextView description;
    TextView score;

    Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        this.title = findViewById(R.id.title1);
        this.description = findViewById(R.id.discription);
        this.score = findViewById(R.id.score);
        this.cont = findViewById(R.id.cont);
        Intent intent = getIntent();
        long idGet =(intent.getLongExtra("id",0));
        title.setText(idGet+"");
        //String des =  .select(idGet).getDescription();
       // description.setText(des);
    }
}
