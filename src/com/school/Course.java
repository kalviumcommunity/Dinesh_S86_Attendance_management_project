package com.school;

public class Course implements Storable {
    private int id;
    private String title;
    private int teacherId; // optionally link by teacher id

    public Course(int id, String title, int teacherId) {
        this.id = id;
        this.title = title;
        this.teacherId = teacherId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getTeacherId() { return teacherId; }

    @Override
    public String toDataString() {
        return String.format("%d,%s,%d", id, escape(title), teacherId);
    }

    private String escape(String s) {
        return s == null ? "" : s.replace(",", "\\,");
    }

    @Override
    public String toString() {
        return String.format("%d: %s (TeacherId: %d)", id, title, teacherId);
    }
}
