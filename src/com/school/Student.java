package com.school;

public class Student {
    private static int nextStudentIdCounter = 1; // auto-increment counter
    private int studentId;
    private String name;

    // Constructor
    public Student(String studentName) {
        this.studentId = nextStudentIdCounter++;
        this.name = studentName;
    }

    public void displayDetails() {
        System.out.println("Student ID: S" + this.studentId + ", Name: " + this.name);
    }
}