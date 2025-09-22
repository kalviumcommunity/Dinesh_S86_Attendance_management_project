import java.util.HashSet;
import java.util.Set;

public class AttendanceRecord {
    private Set<Integer> presentIds = new HashSet<>();

    public void markPresent(int personId) {
        presentIds.add(personId);
        System.out.println("Marked present: ID " + personId);
    }

    public void markAbsent(int personId) {
        presentIds.remove(personId);
        System.out.println("Marked absent: ID " + personId);
    }

    public boolean isPresent(int personId) {
        return presentIds.contains(personId);
    }

    public void printRecords() {
        System.out.println("Attendance Records:");
        if (presentIds.isEmpty()) {
            System.out.println("  (no records)");
            return;
        }
        for (Integer id : presentIds) {
            System.out.println("  Present ID: " + id);
        }
    }
}
