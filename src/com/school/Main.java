package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Create students using constructor
        Student[] students = new Student[3];
        students[0] = new Student("Alice Wonderland");
        students[1] = new Student("Bob The Builder");
        students[2] = new Student("Charlie Brown");

        // Create courses using constructor
        Course[] courses = new Course[3];
        courses[0] = new Course("Intro to Programming");
        courses[1] = new Course("Linear Algebra");
        courses[2] = new Course("Data Structures");

        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            if (student != null) student.displayDetails();
        }

        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            if (course != null) course.displayDetails();
        }

        System.out.println("\nSession 3: Constructor Init & Auto-ID Generation Complete.");
    }
}