package com.example.knead_yourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase  {
    private static final String DATABASE_NAME = "simple.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "TRAININGS";

    private static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME_TRAINING = "NAME_TRAINING";
    public static final String COLUMN_EXERCISE_NAME = "EXERCISE_NAME";
    public static final String COLUMN_EXERCISE_DESCRIPTION = "EXERCISE_DESCRIPTION";

    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_NAME_TRAINING = 1;
    private static final int NUM_COLUMN_EXERCISE_NAME = 2;
    private static final int NUM_COLUMN_EXERCISE_DESCRIPTION = 3;


    private SQLiteDatabase mDataBase;

    public DataBase(Context context) {
        OpenHelper mOpenHelper = new OpenHelper(context);
        mDataBase = mOpenHelper.getWritableDatabase();
    }

    public long insert(String name,String exercise_name,String exercise_description) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME_TRAINING, name);
        cv.put(COLUMN_EXERCISE_NAME, exercise_name);
        cv.put(COLUMN_EXERCISE_DESCRIPTION, exercise_description);
        return mDataBase.insert(TABLE_NAME, null, cv);
    }

    public int update(Trainings md) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME_TRAINING, md.getName());
        cv.put(COLUMN_EXERCISE_NAME, md.getExercise_name());
        cv.put(COLUMN_EXERCISE_DESCRIPTION, md.getExercise_description());
        return mDataBase.update(TABLE_NAME, cv, COLUMN_ID + " = ?",new String[] { String.valueOf(md.getId())});
    }

    public void deleteAll() {
        mDataBase.delete(TABLE_NAME, null, null);
    }

    public void delete(long id) {
        mDataBase.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
    }

    public Trainings select(long id) {
        Cursor mCursor = mDataBase.query(TABLE_NAME, null, COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        mCursor.moveToFirst();
        String name = mCursor.getString(NUM_COLUMN_NAME_TRAINING);
        String exercise_name = mCursor.getString(NUM_COLUMN_EXERCISE_NAME);
        String exercise_description = mCursor.getString(NUM_COLUMN_EXERCISE_DESCRIPTION);
        return new Trainings(id, name, exercise_name, exercise_description);
    }




    private class OpenHelper extends SQLiteOpenHelper {
        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME_TRAINING + " TEXT, " +
                    COLUMN_EXERCISE_NAME + " TEXT, " +
                    COLUMN_EXERCISE_DESCRIPTION + " TEXT);";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}

