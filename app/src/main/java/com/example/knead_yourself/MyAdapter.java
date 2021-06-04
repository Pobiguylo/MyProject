package com.example.knead_yourself;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;



public class MyAdapter extends SimpleCursorAdapter {
    public static  class CustomDialogFragment1 extends DialogFragment {
        private MyAdapter adapter;
        public CustomDialogFragment1(MyAdapter adapter) {
            this.adapter= adapter;
        }
        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            return builder
                    .setTitle("Вы  хотите удалить тренировку?")
                    .setIcon(R.drawable.korzina)
                    .setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            final TableTrainings tableTrainings = new TableTrainings(adapter.context);
                            long id = adapter.c.getLong(adapter.c.getColumnIndex(DataBase.COLUMN_ID));
                            tableTrainings.delete(id);
                            adapter.getCursor().requery();
                            adapter.notifyDataSetInvalidated();
                        }
                    })
                    .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create();
        }
    }

    private Cursor c;
    private Context context;
    public MyAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.c = c;
        this.context = context;
    }


    @Override
    public View getView(final int pos, View inView, final ViewGroup parent) {
        View v = inView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.adapter_view, null);
        }
        this.c.moveToPosition(pos);
        final String trainingName = this.c.getString(this.c.getColumnIndex(DataBase.COLUMN_NAME_TRAINING));
        ImageView iv =  v.findViewById(R.id.imageTitle);
        TextView title =  v.findViewById(R.id.title);

        if (trainingName != null) {
            // If there is no image in the database "NA" is stored instead of a blob
            // test if there more than 3 chars "NA" + a terminating char if more than
            // there is an image otherwise load the default
            if(trainingName.equals("Зарядка для шеи"))
            {
                iv.setImageResource(R.drawable.shei);
            } else if(trainingName.equals("Разминка для рук и плеч"))
            {
                iv.setImageResource(R.drawable.hand);
            } else if (trainingName.equals("Зарядка для глаз")) {
                iv.setImageResource(R.drawable.eyesan);
            } else {
                iv.setImageResource(R.drawable.star);
            }

            title.setText(trainingName);
            title.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/simpletext.ttf"));
        }
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                c.moveToPosition(pos);
                CustomDialogFragment1 dialog = new CustomDialogFragment1(MyAdapter.this);
                dialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "delete");

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
