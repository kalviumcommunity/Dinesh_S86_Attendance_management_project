package com.school;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        FileStorageService fileStorage = new FileStorageService();
        RegistrationService registration = new RegistrationService(fileStorage);
        AttendanceService attendance = new AttendanceService(fileStorage, registration);

        // --- Students ---
        Student s1 = new Student(1, "Alice", 15, "10th");
        Student s2 = new Student(2, "Rahul", 16, "11th");
        Student s3 = new Student(3, "Priya", 15, "10th");
        registration.registerStudent(s1);
        registration.registerStudent(s2);
        registration.registerStudent(s3);

        // --- Teacher ---
        Teacher t1 = new Teacher(101, "Ms. Rao", "Mathematics");
        registration.registerTeacher(t1);

        // --- Course with capacity ---
        registration.createCourse(2001, "Algebra I", t1.getId(), 2);

        Course course = registration.findCourseById(2001);

        // --- Enrollment ---
        registration.enrollStudentInCourse(s1, course);
        registration.enrollStudentInCourse(s2, course);

        // Attempt exceeding capacity
        registration.enrollStudentInCourse(s3, course);

        // Display course details
        System.out.println("\n=== COURSE DETAILS ===");
        course.displayDetails();

        // Save data
        registration.saveAllRegistrations();

        System.out.println("Done! Check courses.txt");
    }
}
