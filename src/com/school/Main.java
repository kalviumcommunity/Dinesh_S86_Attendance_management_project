package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1️⃣ Create services
        FileStorageService storage = new FileStorageService("attendance_log.txt");
        AttendanceService attendanceService = new AttendanceService(storage);

        // 2️⃣ Create students and courses
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student(1, "Alice"));
        allStudents.add(new Student(2, "Bob"));
        allStudents.add(new Student(3, "Charlie"));

        List<Course> allCourses = new ArrayList<>();
        allCourses.add(new Course(101, "Mathematics"));
        allCourses.add(new Course(102, "Physics"));

        // 3️⃣ Use overloaded methods
        attendanceService.markAttendance(allStudents.get(0), allCourses.get(0), "Present");
        attendanceService.markAttendance(allStudents.get(1), allCourses.get(1), "Absent");
        attendanceService.markAttendance(3, 101, "Late", allStudents, allCourses);
        attendanceService.markAttendance(2, 999, "Present", allStudents, allCourses); // invalid course

        // 4️⃣ Display different logs
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(allStudents.get(1));
        attendanceService.displayAttendanceLog(allCourses.get(0));

        // 5️⃣ Save to file
        attendanceService.saveAttendanceData();
    }
}
