package com.example.knead_yourself;

public class Exercise {
    public String name;
    public String description;
    public int score;

    public Exercise(String name, String description,int score) {
        this.name = name;
        this.description = description;
        this.score = score;
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
}
