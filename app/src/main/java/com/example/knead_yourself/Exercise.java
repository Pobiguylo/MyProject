package com.example.knead_yourself;

public class Exercise {
    private String name;
    private String description;
    private String score;

    public long getTrID() {
        return trID;
    }

    public void setTrID(long trID) {
        this.trID = trID;
    }

    private long trID;
    public  long id;
    public Exercise(String name, String description,String score,long trID) {
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
