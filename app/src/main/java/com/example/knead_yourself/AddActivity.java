package com.example.knead_yourself;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_DESCRIPTION;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_SCORE;
import static com.example.knead_yourself.DataBase.COLUMN_NAME_TRAINING;
import static com.example.knead_yourself.DataBase.COLUMN_TRAININGS_ID;
import static com.example.knead_yourself.DataBase.TABLE_EXERCISE;
import static com.example.knead_yourself.DataBase.TABLE_NAME;
import static com.example.knead_yourself.DataBase.COLUMN_EXERCISE_NAME;

public class AddActivity extends AppCompatActivity {
    EditText nameTr;
    EditText nameEx;
    EditText descEx;
    EditText scoreEx;
    Button conTr;
    Button conEx;
    Button end;
    SQLiteDatabase db;

    public class CustomDialogFragment extends DialogFragment {

        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            return builder
                    .setTitle("Диалоговое окно")
                    .setIcon(R.drawable.gal)
                    .setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.nameTr = findViewById(R.id.editTraining);
        this.nameEx = findViewById(R.id.namEx);
        this.descEx = findViewById(R.id.desEx);
        this.scoreEx = findViewById(R.id.scrEx);
        this.conTr = findViewById(R.id.baddTr);
        this.conEx = findViewById(R.id.coEx);
        this.end = findViewById(R.id.end);

        final long[] trID = new long[1];

        final ContentValues cv  =new ContentValues();
        final ContentValues cv1  =new ContentValues();

        if (nameTr.getText().toString().equals(null)) {
            Toast.makeText(this, "Введите название тренировки", Toast.LENGTH_SHORT).show();
        }else

            conTr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Trainings trainings = new Trainings(nameTr.getText().toString());
                    TableTrainings tableTrainings = new TableTrainings(AddActivity.this);
                    tableTrainings.insert(trainings);
                    cv.put(COLUMN_NAME_TRAINING, trainings.getName());
                    trID[0] = db.insert(TABLE_NAME, null, cv);
                }
            });

            if (nameEx.getText().toString().equals(null) || descEx.getText().toString().equals(null)|| scoreEx.getText().toString().equals(null)){
                Toast.makeText(this, "Введите все  данные по упражнениям", Toast.LENGTH_SHORT).show();
            } else {

                conEx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Exercise exercise = new Exercise(nameEx.getText().toString(), descEx.getText().toString(), scoreEx.getText().toString(), trID[0]);
                        TableExercise tableExercise = new TableExercise(AddActivity.this);
                        tableExercise.insert(exercise);
                        cv1.put(COLUMN_EXERCISE_NAME, exercise.getName());
                        cv1.put(COLUMN_EXERCISE_DESCRIPTION, exercise.getDescription());
                        cv1.put(COLUMN_EXERCISE_SCORE, exercise.getScore());
                        cv1.put(COLUMN_TRAININGS_ID, exercise.getTrID());
                        long exID = db.insert(TABLE_EXERCISE, null, cv1);
                    }
                });

                end.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomDialogFragment dialog = new CustomDialogFragment();
                        dialog.show(getSupportFragmentManager(), "confrim");
                    }
                });
            }
    }
}
