package encapsulation.practice_problems;

public class AttendanceSheet {
    private final String[] names;
    private int count;

    public AttendanceSheet(int cap) {
        names = new String[cap];
    }

    public boolean markPresent(String n) {
        if (isPresent(n)) return true;
        if (count == names.length) return false;
        names[count++] = n;
        return true;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String n) {
        for (int i = 0; i < count; i++) if (names[i].equals(n)) return true;
        return false;
    }

    public static void main(String[] x) {
        AttendanceSheet s = new AttendanceSheet(3);
        s.markPresent("Ana");
        s.markPresent("Ben");
        s.markPresent("Ana");
        System.out.println(s.getPresentCount() + " " + s.isPresent("Ben"));
    }
}
