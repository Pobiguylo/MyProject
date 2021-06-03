package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.knead_yourself.DataBase.COLUMN_TRAININGS_ID;
import static com.example.knead_yourself.DataBase.COLUMN_TRAININGS_ID1;
import static com.example.knead_yourself.DataBase.TABLE_EXERCISE;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_NAME;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_DESCRIPTION;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_SCORE;
import static com.example.knead_yourself.DataBase.TABLE_IMAGE;

public class ExerciseActivity extends AppCompatActivity {
    TextView title;
    TextView description;
    TextView score;
    Button cont;
    SQLiteDatabase db;
    ImageView imageView;
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        this.title = findViewById(R.id.title1);
        this.description = findViewById(R.id.discription);
        this.score = findViewById(R.id.score);
        this.cont = findViewById(R.id.cont);
        this.imageView = findViewById(R.id.imageView);



        Intent intent = getIntent();
        final long idGet = (intent.getLongExtra("id", 0));
        DataBase dataBase = new DataBase(this);
        db = dataBase.getReadableDatabase();
        final Cursor c = db.rawQuery("SELECT * FROM " + TABLE_EXERCISE + "   WHERE " + COLUMN_TRAININGS_ID + "=" + idGet, null);
        final Cursor c1 = db.rawQuery("SELECT * FROM " + TABLE_IMAGE + "   WHERE " + COLUMN_TRAININGS_ID1 + "=" + idGet, null);
        if (!c.isAfterLast() ) {
            c.moveToFirst();
            c1.moveToFirst();
            String name = c.getString(c.getColumnIndex(COLUMN_EXERCISE_NAME));
            title.setText(name);
            String desc = c.getString(c.getColumnIndex(COLUMN_EXERCISE_DESCRIPTION));
            description.setText(desc);
            String scor = c.getString(c.getColumnIndex(COLUMN_EXERCISE_SCORE));
            score.setText(scor);
            byte[] image = c1.getBlob(2);
            imageView.setImageBitmap(getImage(image));
        }
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.moveToNext() && c1.moveToNext() ) {
                    if (c != null && c1 !=null ) {
                        String name = c.getString(c.getColumnIndex(COLUMN_EXERCISE_NAME));
                        title.setText(name);
                        String desc = c.getString(c.getColumnIndex(COLUMN_EXERCISE_DESCRIPTION));
                        description.setText(desc);
                        String scor = c.getString(c.getColumnIndex(COLUMN_EXERCISE_SCORE));
                        score.setText(scor);
                        byte[] image = c1.getBlob(2);
                        imageView.setImageBitmap(getImage(image));
                    }
                } else
                    finish();

            }
        });


    }
}

