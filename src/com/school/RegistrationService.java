package com.school;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * RegistrationService - responsible for managing lists of entities:
 * Student, Teacher, Staff, Course.
 *
 * Depends on FileStorageService for persistence.
 */
public class RegistrationService {

    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Staff> staffMembers = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final FileStorageService fileStorage;

    public RegistrationService(FileStorageService fileStorage) {
        this.fileStorage = fileStorage;
    }

    // Registration methods
    public void registerStudent(Student s) {
        students.add(s);
    }

    public void registerTeacher(Teacher t) {
        teachers.add(t);
    }

    public void registerStaff(Staff s) {
        staffMembers.add(s);
    }

    public void createCourse(Course c) {
        courses.add(c);
    }

    // getters
    public List<Student> getStudents() { return new ArrayList<>(students); }
    public List<Teacher> getTeachers() { return new ArrayList<>(teachers); }
    public List<Staff> getStaffMembers() { return new ArrayList<>(staffMembers); }
    public List<Course> getCourses() { return new ArrayList<>(courses); }

    // finders
    public Student findStudentById(int id) {
        Optional<Student> s = students.stream().filter(st -> st.getId() == id).findFirst();
        return s.orElse(null);
    }

    public Course findCourseById(int id) {
        Optional<Course> c = courses.stream().filter(co -> co.getId() == id).findFirst();
        return c.orElse(null);
    }

    public Person findPersonById(int id) {
        for (Student s : students) if (s.getId() == id) return s;
        for (Teacher t : teachers) if (t.getId() == id) return t;
        for (Staff s : staffMembers) if (s.getId() == id) return s;
        return null;
    }

    public List<Person> getAllPeople() {
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }

    /**
     * Save all entity lists to files:
     * students.txt, teachers.txt, staff.txt, courses.txt
     */
    public void saveAllRegistrations() {
        try {
            // ensure files exist
            fileStorage.ensureFile("students.txt");
            fileStorage.ensureFile("teachers.txt");
            fileStorage.ensureFile("staff.txt");
            fileStorage.ensureFile("courses.txt");

            // convert to lines
            List<String> studentLines = students.stream()
                    .map(Storable::toDataString)
                    .collect(Collectors.toList());
            List<String> teacherLines = teachers.stream()
                    .map(Storable::toDataString)
                    .collect(Collectors.toList());
            List<String> staffLines = staffMembers.stream()
                    .map(Storable::toDataString)
                    .collect(Collectors.toList());
            List<String> courseLines = courses.stream()
                    .map(Storable::toDataString)
                    .collect(Collectors.toList());

            // save
            fileStorage.saveLines("students.txt", studentLines);
            fileStorage.saveLines("teachers.txt", teacherLines);
            fileStorage.saveLines("staff.txt", staffLines);
            fileStorage.saveLines("courses.txt", courseLines);

            System.out.println("All registrations saved.");
        } catch (IOException e) {
            System.err.println("Error saving registrations: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
