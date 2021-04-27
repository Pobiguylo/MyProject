package com.example.knead_yourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_DESCRIPTION;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_NAME;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_SCORE;
import static com.example.knead_yourself.DataBase.COLUMN_TRAININGS_ID;
import static com.example.knead_yourself.DataBase.TABLE_EXERCISE;



public class TableExercise {
    private SQLiteDatabase EDataBase;
    public TableExercise(Context context) {
        DataBase EOpenHelper = new DataBase(context);
        EDataBase = EOpenHelper.getWritableDatabase();
    }
    public long insert(Exercise exercise){
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_TRAININGS_ID,exercise.getId());
        cv.put(COLUMN_EXERCISE_NAME,exercise.getName());
        cv.put(COLUMN_EXERCISE_DESCRIPTION,exercise.getDescription());
        cv.put(COLUMN_EXERCISE_SCORE,exercise.getScore());
        return  EDataBase.insert(TABLE_EXERCISE,null,cv);
    }
    public void deleteAll() {
        EDataBase.delete(TABLE_EXERCISE, null, null);
    }

    public void delete(long id) {
        EDataBase.delete(TABLE_EXERCISE, COLUMN_TRAININGS_ID+COLUMN_EXERCISE_NAME+COLUMN_EXERCISE_DESCRIPTION+COLUMN_EXERCISE_SCORE , new String[] { String.valueOf(id) });
    }

    public Exercise select(long id) {
        Cursor mCursor = EDataBase.query(TABLE_EXERCISE, null, COLUMN_TRAININGS_ID + "id", new String[]{String.valueOf(id)}, null, null, null);

        mCursor.moveToFirst();
        String title = mCursor.getString(Integer.parseInt(COLUMN_EXERCISE_NAME));
        String description = mCursor.getString(Integer.parseInt(COLUMN_EXERCISE_DESCRIPTION));
        int score = mCursor.getInt(Integer.parseInt(COLUMN_EXERCISE_SCORE));

        return new Exercise(title,description,score,id);
    }
    public int update(Trainings trainings) { //ДОДЕЛАТЬ ФУНКЦИЮ АПГРЕЙДА
        ContentValues cv=new ContentValues();
        return 0;
    }

}
