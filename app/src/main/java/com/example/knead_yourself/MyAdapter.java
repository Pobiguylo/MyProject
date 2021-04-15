package com.example.knead_yourself;


import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;



public class MyAdapter extends SimpleCursorAdapter {

    public MyAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return super.newView(context, cursor, parent);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.colImp = cursor.getColumnIndexOrThrow(DataBase.COLUMN_NAME_TRAINING);
            holder.listTab = view.findViewById(R.id.listview);
            view.setTag(holder);
        }
        if (cursor.isFirst()) {

        } else {
            // add logic for other rows here
        }
    }

    static class ViewHolder {
        int colImp;
        View listTab;

    }
}
