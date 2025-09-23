package com.school;

public class Student implements Storable {
    private int id;
    private String name;
    private int gradeLevel;

    public Student(int id, String name, int gradeLevel) {
        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    // Getters and setters if needed
    public int getId() { return id; }
    public String getName() { return name; }
    public int getGradeLevel() { return gradeLevel; }

    @Override
    public String toDataString() {
        return id + "," + name + "," + gradeLevel;
    }
}
