package oop_inheritance_and_polymorphism.assignment;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String p) {
        password = p == null ? "" : p;
    }

    public String getStrength() {
        int n = password.length();
        return n < 6 ? "Weak" : n <= 9 ? "Medium" : "Strong";
    }

    public static void main(String[] x) {
        System.out.println(new PasswordChecker("abcdefghij").getStrength());
    }
}
