package com.school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(101, "John", 10));
        students.add(new Student(102, "Alice", 9));

        // Create courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course(201, "Math"));
        courses.add(new Course(202, "Science"));

        // Create attendance records
        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(101, 201, "Present"));
        records.add(new AttendanceRecord(102, 202, "Absent"));

        // Save to files
        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");
    }
}
