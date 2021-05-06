package com.example.knead_yourself;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
            if(trainingName.equals("Head"))
            {
                iv.setImageResource(R.drawable.head);
            } else if(trainingName.equals("Hand"))
            {
                iv.setImageResource(R.drawable.hand);
            } else if (trainingName.equals("Eyes")) {
                iv.setImageResource(R.drawable.eyes);
            }

            TextView title =  v.findViewById(R.id.title);
            title.setText(trainingName);
        }
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
