package com.example.knead_yourself;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;
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
    Trainings trainings;
    Exercise exercise;
    TextView descTex;
    public static class CustomDialogFragment extends DialogFragment {
        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            return builder
                    .setTitle("Вы точно хотите создать тренировку?")
                    .setIcon(R.drawable.gal)
                    .setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Objects.requireNonNull(getActivity()).finish();
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
        this.descTex = findViewById(R.id.descText);
        DataBase dataBase = new DataBase(this);
        db = dataBase.getReadableDatabase();

        final long[] trID = new long[1];
        final ContentValues cv  =new ContentValues();
        final ContentValues cv1  =new ContentValues();



            conTr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (nameTr.getText().toString().equals("")) {
                    Toast.makeText(AddActivity.this, "Введите название тринировки", Toast.LENGTH_SHORT).show();
                }else {
                        trainings = new Trainings(nameTr.getText().toString());
                        cv.put(COLUMN_NAME_TRAINING, trainings.getName());
                        trID[0] = db.insert(TABLE_NAME, null, cv);
                        Toast.makeText(AddActivity.this, "Тренировка создана", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            descEx.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String s1 =descEx.getText().toString();
                    descTex.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/simpletext.ttf"));
                    descTex.setText(s1);
                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                }
                @Override
                public void afterTextChanged(Editable s) {

                }
            });

                conEx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (nameEx.getText().toString().equals("") || descEx.getText().toString().equals("")|| scoreEx.getText().toString().equals("")|| nameTr.getText().toString().equals("")){
                        Toast.makeText(AddActivity.this, "Введите все  данные по упражнениям", Toast.LENGTH_SHORT).show();
                    } else {
                            exercise = new Exercise(nameEx.getText().toString(), descEx.getText().toString(), scoreEx.getText().toString(), trID[0]);
                            cv1.put(COLUMN_EXERCISE_NAME, exercise.getName());
                            cv1.put(COLUMN_EXERCISE_DESCRIPTION, exercise.getDescription());
                            cv1.put(COLUMN_EXERCISE_SCORE, exercise.getScore());
                            cv1.put(COLUMN_TRAININGS_ID, exercise.getTrID());
                            trainings.add(exercise);
                            long exID = db.insert(TABLE_EXERCISE, null, cv1);
                            nameEx.setText("");
                            descEx.setText("");
                            scoreEx.setText("");
                            Toast.makeText(AddActivity.this, "Упражнение создано", Toast.LENGTH_SHORT).show();
                        }
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
