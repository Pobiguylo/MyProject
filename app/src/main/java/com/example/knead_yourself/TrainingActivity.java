package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class TrainingActivity extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase db;
    Cursor userCursor;
    TextView list;
    SimpleCursorAdapter userAdapter;
    DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.listView = findViewById(R.id.listview);
        this.list = findViewById(R.id.List);
        list.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/simpletext.ttf"));
         dataBase = new DataBase(getApplicationContext());

    }

    public void onResume() {
        super.onResume();
        // открываем подключение
        db = dataBase.getReadableDatabase();

        //получаем данные из бд в виде курсора
        userCursor =  db.rawQuery("select * from "+ DataBase.TABLE_NAME, null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[] {DataBase.COLUMN_NAME_TRAINING,"_id"};
        // создаем адаптер, передаем в него курсор
        userAdapter = new MyAdapter(this, R.layout.adapter_view,
                userCursor, headers, new int[]{R.id.title}, 0);
        listView.setAdapter(userAdapter);

    }

}
