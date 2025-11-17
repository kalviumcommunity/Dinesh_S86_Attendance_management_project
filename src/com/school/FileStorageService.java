package com.school;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStorageService {

    /**
     * Save lines to filename (overwrite).
     */
    public void saveLines(String filename, List<String> lines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    /**
     * Append a single line (useful for logs)
     */
    public void appendLine(String filename, String line) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(line);
            bw.newLine();
        }
    }

    /**
     * Simple exist check (create empty file if not present)
     */
    public void ensureFile(String filename) throws IOException {
        if (!Files.exists(Paths.get(filename))) {
            saveLines(filename, List.of());
        }
    }
}
