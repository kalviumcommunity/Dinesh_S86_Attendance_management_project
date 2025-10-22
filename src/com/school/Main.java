package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // New Polymorphic method
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory ===");
        for (Person person : people) {
            person.displayDetails(); // polymorphic call
            System.out.println();
        }
        System.out.println("=========================\n");
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System (Part 7) ---");

        // Create Students
        Student s1 = new Student("Alice Wonderland", "Grade 8");
        Student s2 = new Student("Bob The Builder", "Grade 9");
        Student s3 = new Student("Charlie Brown", "Grade 10");

        // Create Teachers
        Teacher t1 = new Teacher("Mr. Brown", "Mathematics");
        Teacher t2 = new Teacher("Mrs. Smith", "Physics");

        // Create Staff
        Staff st1 = new Staff("Mrs. Green", "Librarian");

        // Create Courses
        Course c1 = new Course("Intro to Programming");
        Course c2 = new Course("Linear Algebra");
        Course c3 = new Course("Data Structures");

        // Combine all persons into one polymorphic list
        ArrayList<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1);
        schoolPeople.add(s2);
        schoolPeople.add(s3);
        schoolPeople.add(t1);
        schoolPeople.add(t2);
        schoolPeople.add(st1);

        // Display directory polymorphically
        displaySchoolDirectory(schoolPeople);

        // Attendance Records
        System.out.println("Recording Attendance...\n");
        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1, c1, "Present"));
        attendanceLog.add(new AttendanceRecord(s2, c2, "Absent"));
        attendanceLog.add(new AttendanceRecord(s3, c3, "Late")); // invalid -> warning

        // Display Attendance Log
        System.out.println("=== Attendance Log ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Prepare Students list for saving (using instanceof)
        List<Student> studentsToSave = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                studentsToSave.add((Student) p);
            }
        }

        // Save Data
        FileStorageService storage = new FileStorageService();
        storage.saveData(studentsToSave, "students.txt");
        storage.saveData(List.of(c1, c2, c3), "courses.txt");
        storage.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\n✅ Session 7: Polymorphism Demonstration Complete.");
    }
}