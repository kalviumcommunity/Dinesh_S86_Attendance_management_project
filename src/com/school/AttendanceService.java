package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // Overloaded Method 1
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("✅ Marked: " + record);
    }

    // Overloaded Method 2
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student s = findStudentById(studentId, allStudents);
        Course c = findCourseById(courseId, allCourses);

        if (s == null) {
            System.err.println("❌ Student with id " + studentId + " not found.");
            return;
        }
        if (c == null) {
            System.err.println("❌ Course with id " + courseId + " not found.");
            return;
        }

        markAttendance(s, c, status);
    }

    private Student findStudentById(int id, List<Student> allStudents) {
        if (allStudents == null) return null;
        Optional<Student> opt = allStudents.stream().filter(st -> st.getId() == id).findFirst();
        return opt.orElse(null);
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        if (allCourses == null) return null;
        Optional<Course> opt = allCourses.stream().filter(c -> c.getId() == id).findFirst();
        return opt.orElse(null);
    }

    public void displayAttendanceLog() {
        System.out.println("\\n=== 📘 Full Attendance Log ===");
        if (attendanceLog.isEmpty()) {
            System.out.println("(no records)");
            return;
        }
        attendanceLog.forEach(System.out::println);
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\\n=== 📗 Attendance for Student: " + student.getName() + " ===");
        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getStudent().getId() == student.getId())
                .collect(Collectors.toList());
        if (filtered.isEmpty()) System.out.println("(no records)");
        filtered.forEach(System.out::println);
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\\n=== 📙 Attendance for Course: " + course.getTitle() + " ===");
        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getCourse().getId() == course.getId())
                .collect(Collectors.toList());
        if (filtered.isEmpty()) System.out.println("(no records)");
        filtered.forEach(System.out::println);
    }

    public void saveAttendanceData() {
        storageService.saveData(this.attendanceLog);
    }
}
