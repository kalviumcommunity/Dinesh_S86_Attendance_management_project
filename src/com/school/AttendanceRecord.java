package com.school;

public class AttendanceRecord implements Storable {
    private int studentId;
    private int courseId;
    private String status;

    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getStatus() { return status; }

    @Override
    public String toDataString() {
        return studentId + "," + courseId + "," + status;
    }
}
