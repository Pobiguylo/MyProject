package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.knead_yourself.DataBase.COLUMN_TRAININGS_ID;
import static com.example.knead_yourself.DataBase.TABLE_EXERCISE;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_NAME;
public class ExerciseActivity extends AppCompatActivity {
    TextView title;
    TextView description;
    TextView score;
    Button cont;
    //DataBase dataBase;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        this.title = findViewById(R.id.title1);
        this.description = findViewById(R.id.discription);
        this.score = findViewById(R.id.score);
        this.cont = findViewById(R.id.cont);
        Intent intent = getIntent();
        long idGet = (intent.getLongExtra("id", 0));
        DataBase dataBase = new DataBase(this);
        db = dataBase.getReadableDatabase();
         final Cursor c = db.rawQuery("SELECT * FROM "+TABLE_EXERCISE+"   WHERE "+COLUMN_TRAININGS_ID+"="+ idGet,null);
         c.moveToFirst();
         cont.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if( c != null  ) {
                     String name = c.getString(c.getColumnIndex(COLUMN_EXERCISE_NAME));
                     title.setText(name);
                     c.moveToNext();
                 } else{
                     c.close();}
             }
         });


    }
}

