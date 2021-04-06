package com.example.knead_yourself;

public class Exercise {
    public String name;
    public String description;

    public Exercise(String name, String Description) {
        this.name = name;
        this.description = Description;
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
}
