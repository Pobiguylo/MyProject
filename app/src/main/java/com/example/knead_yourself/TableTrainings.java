package com.example.knead_yourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import static com.example.knead_yourself.DataBase.COLUMN_NAME_TRAINING;
import static com.example.knead_yourself.DataBase.TABLE_NAME;


public class TableTrainings {
    private SQLiteDatabase TDataBase;

    public TableTrainings(Context context) {
        DataBase tOpenHelper = new DataBase(context);
        TDataBase = tOpenHelper.getWritableDatabase();
    }
    public long insert(Trainings trainings){
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME_TRAINING,trainings.getName());
        return  TDataBase.insert(TABLE_NAME,null,cv);
    }
    public void deleteAll() {
        TDataBase.delete(TABLE_NAME, null, null);
    }

    public void delete(long id) {
        TDataBase.delete(TABLE_NAME, COLUMN_NAME_TRAINING + " =? ", new String[] { String.valueOf(id) });
    }
    public int update(Trainings trainings) { //ДОДЕЛАТЬ ФУНКЦИЮ АПГРЕЙДА
        ContentValues cv=new ContentValues();
        return 0;
    }

}
