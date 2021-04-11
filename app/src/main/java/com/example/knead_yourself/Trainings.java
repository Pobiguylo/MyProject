package com.example.knead_yourself;

import java.io.Serializable;
import java.util.ArrayList;

public class Trainings implements Serializable {
    private long id;
    private String name;
    ArrayList<Exercise> exercises;
    public Trainings(long id, String name, ArrayList<Exercise> exercises) {
        this.id = id;
        this.name = name;
        exercises = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void add(Exercise exercise){
        this.exercises.add(exercise);
    }
}
