package com.school;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * AttendanceService: responsibility limited to attendance management.
 * It uses RegistrationService for lookups by id.
 */
public class AttendanceService {

    private final List<String> attendanceRecords = new ArrayList<>();
    private final FileStorageService fileStorage;
    private final RegistrationService registrationService;

    public AttendanceService(FileStorageService fileStorage, RegistrationService registrationService) {
        this.fileStorage = fileStorage;
        this.registrationService = registrationService;
    }

    /**
     * Mark attendance by IDs: looks up student and course using registrationService.
     * status could be "present", "absent", etc.
     */
    public boolean markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student == null) {
            System.err.println("Attendance error: Student id " + studentId + " not found.");
            return false;
        }
        if (course == null) {
            System.err.println("Attendance error: Course id " + courseId + " not found.");
            return false;
        }

        String timestamp = LocalDateTime.now().toString();
        String record = String.format("%s,studentId=%d,studentName=%s,courseId=%d,courseTitle=%s,status=%s",
                timestamp, studentId, student.getName(), courseId, course.getTitle(), status);
        attendanceRecords.add(record);
        System.out.println("Marked attendance: " + record);
        return true;
    }

    /**
     * Save attendance records to a file (append)
     */
    public void saveAttendanceData() {
        try {
            fileStorage.ensureFile("attendance_log.txt");
            for (String line : attendanceRecords) {
                fileStorage.appendLine("attendance_log.txt", line);
            }
            // clear in-memory after save (optional)
            attendanceRecords.clear();
            System.out.println("Attendance data saved.");
        } catch (IOException e) {
            System.err.println("Failed to save attendance: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
