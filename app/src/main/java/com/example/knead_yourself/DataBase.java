package com.example.knead_yourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends  SQLiteOpenHelper  {
    private static final String DATABASE_NAME = "trainings.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "TRAININGS";

    private static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME_TRAINING = "NAME_TRAINING";
    public static final String COLUMN_EXERCISE_NAME1 = "EXERCISE_NAME1";
    public static final String COLUMN_EXERCISE_DESCRIPTION1 = "EXERCISE_DESCRIPTION1";
    public static final String COLUMN_EXERCISE_NAME2 = "EXERCISE_NAME2";
    public static final String COLUMN_EXERCISE_DESCRIPTION2 = "EXERCISE_DESCRIPTION2";
    public static final String COLUMN_EXERCISE_NAME3 = "EXERCISE_NAME3";
    public static final String COLUMN_EXERCISE_DESCRIPTION3 = "EXERCISE_DESCRIPTION3";
    public static final String COLUMN_EXERCISE_NAME4 = "EXERCISE_NAME4";
    public static final String COLUMN_EXERCISE_DESCRIPTION4 = "EXERCISE_DESCRIPTION4";
    public static final String COLUMN_EXERCISE_NAME5 = "EXERCISE_NAME5";
    public static final String COLUMN_EXERCISE_DESCRIPTION5 = "EXERCISE_DESCRIPTION5";
    public static final String COLUMN_EXERCISE_NAME6 = "EXERCISE_NAME6";
    public static final String COLUMN_EXERCISE_DESCRIPTION6 = "EXERCISE_DESCRIPTION6";
    public static final String COLUMN_EXERCISE_NAME7 = "EXERCISE_NAME7";
    public static final String COLUMN_EXERCISE_DESCRIPTION7 = "EXERCISE_DESCRIPTION7";
    public static final String COLUMN_EXERCISE_NAME8 = "EXERCISE_NAME8";
    public static final String COLUMN_EXERCISE_DESCRIPTION8 = "EXERCISE_DESCRIPTION8";
    public static final String COLUMN_EXERCISE_NAME9 = "EXERCISE_NAME9";
    public static final String COLUMN_EXERCISE_DESCRIPTION9 = "EXERCISE_DESCRIPTION9";
    public static final String COLUMN_EXERCISE_NAME10 = "EXERCISE_NAME10";
    public static final String COLUMN_EXERCISE_DESCRIPTION10 = "EXERCISE_DESCRIPTION10";
    DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = ("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_TRAINING + " TEXT, " +
                COLUMN_EXERCISE_NAME1 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION1 + " TEXT, "+
                COLUMN_EXERCISE_NAME2 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION2 + " TEXT, "+
                COLUMN_EXERCISE_NAME3 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION3 + " TEXT, "+
                COLUMN_EXERCISE_NAME4 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION4 + " TEXT, "+
                COLUMN_EXERCISE_NAME5 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION5 + " TEXT, "+
                COLUMN_EXERCISE_NAME6 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION6 + " TEXT, "+
                COLUMN_EXERCISE_NAME7 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION7 + " TEXT, "+
                COLUMN_EXERCISE_NAME8 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION8 + " TEXT, "+
                COLUMN_EXERCISE_NAME9 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION9 + " TEXT, "+
                COLUMN_EXERCISE_NAME10 + " TEXT, " +
                COLUMN_EXERCISE_DESCRIPTION10 + " TEXT);");
        db.execSQL(query);
        Trainings tr1 = new Trainings(1,"Head","ex1","dec1","ex2","dec2","ex3","dec3","ex4","dec4","ex5","dec5",null,null,null,null,null,null,null,null,null,null);
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COLUMN_NAME_TRAINING
                + ", " + COLUMN_EXERCISE_NAME1 +", "+COLUMN_EXERCISE_DESCRIPTION1+", "
                + COLUMN_EXERCISE_NAME2 +", "+COLUMN_EXERCISE_DESCRIPTION3+", "
                + COLUMN_EXERCISE_NAME3 +", "+COLUMN_EXERCISE_DESCRIPTION3+", "
                + COLUMN_EXERCISE_NAME4 +", "+COLUMN_EXERCISE_DESCRIPTION4+", "
                + COLUMN_EXERCISE_NAME5 +", "+COLUMN_EXERCISE_DESCRIPTION5+", "
                + COLUMN_EXERCISE_NAME6 +", "+COLUMN_EXERCISE_DESCRIPTION6+", "
                + COLUMN_EXERCISE_NAME7 +", "+COLUMN_EXERCISE_DESCRIPTION7+", "
                + COLUMN_EXERCISE_NAME8 +", "+COLUMN_EXERCISE_DESCRIPTION8+", "
                + COLUMN_EXERCISE_NAME9 +", "+COLUMN_EXERCISE_DESCRIPTION9+", "
                + COLUMN_EXERCISE_NAME10 +", "+COLUMN_EXERCISE_DESCRIPTION10+") VALUES (tr1.getName,tr1.getExercise_name1,tr1.getExercise_description1,tr1.getExercise_name2,tr1.getExercise_description2,tr1.getExercise_name3,tr1.getExercise_description3,tr1.getExercise_name4,tr1.getExercise_description4,tr1.getExercise_name5,tr1.getExercise_description5,tr1.getExercise_name6,tr1.getExercise_description6,tr1.getExercise_name7,tr1.getExercise_description7,tr1.getExercise_name8,tr1.getExercise_description8,tr1.getExercise_name9,tr1.getExercise_description9,tr1.getExercise_name10,tr1.getExercise_description10);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    }







