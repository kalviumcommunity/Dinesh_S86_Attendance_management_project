package com.school;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // instantiate helpers/services
        FileStorageService fileStorage = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(fileStorage);
        AttendanceService attendanceService = new AttendanceService(fileStorage, registrationService);

        // Register some students, teachers, staff and create courses via registrationService
        Student s1 = new Student(1, "Alice Kumar", 15, "10th");
        Student s2 = new Student(2, "Rahul Reddy", 16, "11th");
        registrationService.registerStudent(s1);
        registrationService.registerStudent(s2);

        Teacher t1 = new Teacher(101, "Ms. Rao", "Mathematics");
        registrationService.registerTeacher(t1);

        Staff st1 = new Staff(201, "Mr. Sharma", "Clerk");
        registrationService.registerStaff(st1);

        Course c1 = new Course(1001, "Algebra I", t1.getId());
        registrationService.createCourse(c1);

        // display directory (uses registrationService)
        System.out.println("---- School Directory ----");
        displaySchoolDirectory(registrationService);

        // mark attendance using IDs (attendanceService uses registrationService internally)
        attendanceService.markAttendance(1, 1001, "present");
        attendanceService.markAttendance(2, 1001, "absent");
        attendanceService.markAttendance(999, 1001, "present"); // demonstrates not found handling

        // save all data
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("Done. Check students.txt, teachers.txt, staff.txt, courses.txt and attendance_log.txt");
    }

    private static void displaySchoolDirectory(RegistrationService regService) {
        List<Person> people = regService.getAllPeople();
        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}
