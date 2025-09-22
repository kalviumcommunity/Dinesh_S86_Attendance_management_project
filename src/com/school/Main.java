public class Main {
    public static void main(String[] args) {
        Student s = new Student("Asha", "10th Grade");
        Teacher t = new Teacher("Mr. Rao", "Mathematics");
        Staff st = new Staff("Kumar", "Accountant");

        s.displayDetails();
        System.out.println();
        t.displayDetails();
        System.out.println();
        st.displayDetails();
        System.out.println();

        AttendanceRecord ar = new AttendanceRecord();
        ar.markPresent(s.getId());        // <-- using student.getId() as required
        ar.printRecords();
    }
}
