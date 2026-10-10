package string.class_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
    public static boolean isPalindromeRecursive(String s) {
        return check(s, 0, s.length() - 1);
    }
    private static boolean check(String s, int l, int r) {
        return l >= r || (s.charAt(l) == s.charAt(r) && check(s, l + 1, r - 1));
    }
    public static boolean isPalindromeArrayReversal(String s) {
        char[] a = s.toCharArray();
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            char c = a[l];
            a[l] = a[r];
            a[r] = c;
        }
        return s.equals(new String(a));
    }
    public static void main(String[] x) {
        String s = x.length == 0 ? "madam" : x[0];
        System.out.println("Iterative: " + isPalindromeIterative(s) + " | Recursive: " + isPalindromeRecursive(s) + " | Array Reversal: " + isPalindromeArrayReversal(s));
    }
}
