package com.school;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RegistrationService {

    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Staff> staffMembers = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final FileStorageService fileStorage;

    public RegistrationService(FileStorageService fileStorage) {
        this.fileStorage = fileStorage;
    }

    // --- Registration ---
    public void registerStudent(Student s) { students.add(s); }
    public void registerTeacher(Teacher t) { teachers.add(t); }
    public void registerStaff(Staff s) { staffMembers.add(s); }

    public void createCourse(int id, String title, int teacherId, int capacity) {
        Course c = new Course(id, title, teacherId, capacity);
        courses.add(c);
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean success = course.addStudent(student);
        if (success) {
            System.out.println("✔ Enrolled " + student.getName() + " into " + course.getTitle());
        } else {
            System.out.println("❌ Could NOT enroll " + student.getName() + " into " + course.getTitle()
                    + " — Course is full!");
        }
        return success;
    }

    // --- Finders ---
    public Student findStudentById(int id) {
        return students.stream().filter(st -> st.getId() == id).findFirst().orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream().filter(co -> co.getId() == id).findFirst().orElse(null);
    }

    public List<Person> getAllPeople() {
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }

    public List<Course> getCourses() { return courses; }

    // --- Save All ---
    public void saveAllRegistrations() {
        try {
            fileStorage.ensureFile("students.txt");
            fileStorage.ensureFile("teachers.txt");
            fileStorage.ensureFile("staff.txt");
            fileStorage.ensureFile("courses.txt");

            fileStorage.saveLines("students.txt",
                    students.stream().map(Storable::toDataString).collect(Collectors.toList()));

            fileStorage.saveLines("teachers.txt",
                    teachers.stream().map(Storable::toDataString).collect(Collectors.toList()));

            fileStorage.saveLines("staff.txt",
                    staffMembers.stream().map(Storable::toDataString).collect(Collectors.toList()));

            fileStorage.saveLines("courses.txt",
                    courses.stream().map(Storable::toDataString).collect(Collectors.toList()));

        } catch (IOException e) {
            System.err.println("Error saving registrations: " + e.getMessage());
        }
    }
}
