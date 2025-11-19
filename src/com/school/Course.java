package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private int id;
    private String title;
    private int teacherId;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(int id, String title, int teacherId, int capacity) {
        this.id = id;
        this.title = title;
        this.teacherId = teacherId;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getTeacherId() { return teacherId; }
    public int getCapacity() { return capacity; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public int getNumberOfEnrolledStudents() { return enrolledStudents.size(); }

    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled Students: " + getNumberOfEnrolledStudents());
        System.out.println("-----------------------");
    }

    @Override
    public String toDataString() {
        return String.format("%d,%s,%d,%d", id, escape(title), teacherId, capacity);
    }

    private String escape(String s) {
        return s == null ? "" : s.replace(",", "\\,");
    }
}
