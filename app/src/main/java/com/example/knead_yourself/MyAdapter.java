package com.example.knead_yourself;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MyAdapter extends SimpleCursorAdapter {
    private Cursor c;
    private Context context;
    public MyAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.c = c;
        this.context = context;
    }


    @Override
    public View getView(final int pos, View inView, ViewGroup parent) {
        View v = inView;
        final TableTrainings tableTrainings = new TableTrainings(context);
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.adapter_view, null);
        }
        this.c.moveToPosition(pos);
        String trainingName = this.c.getString(this.c.getColumnIndex(DataBase.COLUMN_NAME_TRAINING));
        ImageView iv =  v.findViewById(R.id.imageTitle);
        if (trainingName != null) {
            // If there is no image in the database "NA" is stored instead of a blob
            // test if there more than 3 chars "NA" + a terminating char if more than
            // there is an image otherwise load the default
            if(trainingName.equals("Зарядка для шеи"))
            {
                iv.setImageResource(R.drawable.head);
            } else if(trainingName.equals("Разминка для рук и плеч"))
            {
                iv.setImageResource(R.drawable.hand);
            } else if (trainingName.equals("Зарядка для глаз")) {
                iv.setImageResource(R.drawable.eyes);
            }

            TextView title =  v.findViewById(R.id.title);
            title.setText(trainingName);
        }
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                c.moveToPosition(pos);
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                long id = MyAdapter.this.c.getLong(MyAdapter.this.c.getColumnIndex(DataBase.COLUMN_ID));
                tableTrainings.delete(id);
                return false;
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.moveToPosition(pos);
                long id = MyAdapter.this.c.getLong(MyAdapter.this.c.getColumnIndex(DataBase.COLUMN_ID));
                Intent intent  = new Intent(context,ExerciseActivity.class);
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });

        return(v);
    }
}
