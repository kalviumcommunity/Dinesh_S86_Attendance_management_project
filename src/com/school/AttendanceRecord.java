package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("⚠ Warning: Invalid status entered. Allowed values: Present/Absent.");
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Student: " + student.getName() + " (ID: " + student.getId() + ")");
        System.out.println("Course : " + course.getCourseName() + " (C" + course.getCourseId() + ")");
        System.out.println("Status : " + status);
        System.out.println("---------------------------------");
    }

    @Override
    public String toDataString() {
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}