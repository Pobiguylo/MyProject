package com.example.knead_yourself;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class Trainings implements Serializable {
    private String name;

    public long getId() {
        return id;
    }

    private  long id;
     private ArrayList<Exercise> exercises;
    public Trainings( String name, ArrayList<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }
    public Trainings( String name) {
        this.name = name;
        this.exercises = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercices() {
        return exercises;
    }

    public void add(Exercise exercise){
        this.exercises.add(exercise);
    }
}
