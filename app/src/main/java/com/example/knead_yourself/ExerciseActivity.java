package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import static com.example.knead_yourself.DataBase.TABLE_EXERCISE;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_NAME;

public class ExerciseActivity extends AppCompatActivity {
    TextView title;
    TextView description;
    DataBase dataBase;
    SQLiteDatabase db;
    long DIFFICULTY_EASY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        this.title = findViewById(R.id.title1);
        this.description = findViewById(R.id.discription);
        dataBase = new DataBase(getApplicationContext());
        db = dataBase.getReadableDatabase();
        long userId = getIntent().getLongExtra("id", DIFFICULTY_EASY);
        Log.d("my", "лог" + userId);
        String selection = "_id = ?";
        String[] selectionArgs = new String[]{String.valueOf(userId)};
        Cursor c = db.query(TABLE_EXERCISE, null, selection, selectionArgs, null, null, null);
        if (c.moveToFirst()) {

        }
    }
}
