package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Create students
        Student[] students = new Student[3];
        students[0] = new Student("Alice Wonderland");
        students[1] = new Student("Bob The Builder");
        students[2] = new Student("Charlie Brown");

        // Create courses
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

        // ✅ Attendance Recording
        System.out.println("\nRecording Attendance...");

        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        AttendanceRecord r1 = new AttendanceRecord(students[0].getStudentId(), courses[0].getCourseId(), "Present");
        AttendanceRecord r2 = new AttendanceRecord(students[1].getStudentId(), courses[1].getCourseId(), "Absent");
        AttendanceRecord r3 = new AttendanceRecord(students[2].getStudentId(), courses[2].getCourseId(), "Late"); // invalid

        attendanceLog.add(r1);
        attendanceLog.add(r2);
        attendanceLog.add(r3);

        System.out.println("\nAttendance Log:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nSession 4: Encapsulation & Attendance Recording Complete.");
    }
}