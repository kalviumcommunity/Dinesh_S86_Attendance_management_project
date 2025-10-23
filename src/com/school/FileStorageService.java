package com.school;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileStorageService {
    private String filename;

    public FileStorageService(String filename) {
        this.filename = filename;
    }

    public void saveData(List<AttendanceRecord> attendanceLog) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) {
            for (AttendanceRecord r : attendanceLog) {
                bw.write(r.toLogLine());
                bw.newLine();
            }
            System.out.println("✅ Saved " + attendanceLog.size() + " attendance records to " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error saving attendance data: " + e.getMessage());
        }
    }
}
