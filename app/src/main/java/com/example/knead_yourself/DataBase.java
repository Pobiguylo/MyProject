package com.example.knead_yourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "trainings.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "TRAININGS";
    public static final String TABLE_EXERCISE = "EXERCISE";

    private static final String COLUMN_ID = "id";
    public static final String COLUMN_TRAININGS_ID="COLUMN_TRAININGS_ID";
    public static final String COLUMN_NAME_TRAINING = "NAME";
    public static final String COLUMN_EXERCISE_NAME = "NAME";
    public static final String COLUMN_EXERCISE_DESCRIPTION = "DESCRIPTION";

    DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = ("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_TRAINING + " TEXT); ");
        db.execSQL(query);
        String query1 = ("CREATE TABLE " + TABLE_EXERCISE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TRAININGS_ID + " INTEGER,"+
                COLUMN_EXERCISE_NAME+"TEXT,"+
                COLUMN_EXERCISE_DESCRIPTION+"TEXT);");
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}







