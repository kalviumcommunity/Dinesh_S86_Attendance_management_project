package com.school;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AttendanceRecord {
    private Student student;
    private Course course;
    private String status;
    private LocalDateTime timestamp;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public String getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public String toLogLine() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return student.getId() + "," + student.getName() + "," + course.getId() + "," + course.getTitle() + "," + status + "," + timestamp.format(fmt);
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + student.getName() + " (id=" + student.getId() + ") - "
                + course.getTitle() + " (id=" + course.getId() + ") => " + status;
    }
}
