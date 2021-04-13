package com.example.knead_yourself;

public class Exercise {
    private String name;
    private String description;
    private int score;
    private long trID;
    public  long id;
    public Exercise(String name, String description,int score,long trID) {
        this.name = name;
        this.description = description;
        this.score = score;
        this.trID =trID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
