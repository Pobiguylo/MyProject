package com.example.knead_yourself;

import java.io.Serializable;

public class Trainings implements Serializable {
    private long id;
    private String name;
    private String exercise_name;
    private String exercise_description;

    public Trainings(long id, String name, String exercise_name, String exercise_description) {
        this.id = id;
        this.name = name;
        this.exercise_name = exercise_name;
        this.exercise_description = exercise_description;
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

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getExercise_description() {
        return exercise_description;
    }

    public void setExercise_description(String exercise_description) {
        this.exercise_description = exercise_description;
    }
}
