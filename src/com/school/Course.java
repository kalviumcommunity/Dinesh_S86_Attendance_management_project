package com.school;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    private int courseId;
    private String courseName;

    public Course(String cName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = cName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + this.courseId + ", Name: " + this.courseName);
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName;
    }
}