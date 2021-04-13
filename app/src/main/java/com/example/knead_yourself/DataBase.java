package com.example.knead_yourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.json.JSONArray;


public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "trainings.db";
    private static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME = "TRAININGS";
    public static final String TABLE_EXERCISE = "EXERCISE";

    private static final String COLUMN_ID = "_id";
    public static final String COLUMN_TRAININGS_ID="TRAININGS_ID";
    public static final String COLUMN_NAME_TRAINING = "NAME";
    public static final String COLUMN_EXERCISE_NAME = "NAME";
    public static final String COLUMN_EXERCISE_DESCRIPTION = "DESCRIPTION";
    public static final String COLUMN_EXERCISE_SCORE = "SCORE";

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
                COLUMN_EXERCISE_DESCRIPTION+"TEXT,"+
                COLUMN_EXERCISE_SCORE+"INTEGER);");
        db.execSQL(query1);

        ContentValues cv=new ContentValues();
        ContentValues cv1 = new ContentValues();

        Trainings tr1 = new Trainings("Head");
        cv.put(COLUMN_NAME_TRAINING,tr1.getName());
        long trID =  db.insert(TABLE_NAME,null,cv);

        Trainings tr2 = new Trainings("Hand");
        cv.put(COLUMN_NAME_TRAINING,tr2.getName());
        long trId1 = db.insert(TABLE_NAME,null,cv);

        Exercise ex1 = new Exercise("Up","fast",15,trID);
        cv1.put(COLUMN_EXERCISE_NAME,ex1.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex1.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex1.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex1.getId());
        tr1.add(ex1);
        long Exid = db.insert(TABLE_EXERCISE,null,cv1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISE);
        onCreate(db);
    }

}







