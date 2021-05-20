package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {
    EditText nameTr;
    EditText nameEx;
    EditText descEx;
    EditText scoreEx;
    Button conTr;
    Button conEx;
    Button end;
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

    }
}
