package encapsulation.practice_problems;

public class LockerCode {
    public static class Locker {
        private final int lockerNumber;
        private String code;

        public Locker(int n, String c) {
            lockerNumber = n;
            code = c;
        }

        public int getLockerNumber() {
            return lockerNumber;
        }

        public boolean changeCode(String current, String next) {
            if (code.equals(current) && next != null && !next.isEmpty()) {
                code = next;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] x) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678"));
        System.out.println(l.changeCode("0000", "9999"));
    }
}
