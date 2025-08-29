package com.school;

public class AttendanceRecord {
    private int studentId;
    private int courseId;
    private String status;

    // Constructor with validation
    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;

        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("⚠ Warning: Invalid status entered. Allowed values: Present/Absent.");
        }
    }

    // ✅ Getters
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    // Display method
    public void displayRecord() {
        System.out.println("Student ID: S" + studentId +
                           ", Course ID: C" + courseId +
                           ", Status: " + status);
    }
}