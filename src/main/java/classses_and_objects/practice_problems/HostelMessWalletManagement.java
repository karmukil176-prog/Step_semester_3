package classses_and_objects.practice_problems;

public class HostelMessWalletManagement {
    public static class MessWallet {
        private double balance;

        public MessWallet(double b) {
            if (b < 0) {
                System.out.println("Warning: negative balance set to 0");
                b = 0;
            }
            balance = b;
        }

        public void topUp(double a) {
            if (a <= 0) System.out.println("Invalid top-up");
            else balance += a;
        }

        public void deduct(double a) {
            if (a <= 0 || a > balance) System.out.println("Deduction rejected");
            else balance -= a;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] x) {
        MessWallet w = new MessWallet(5);
        w.deduct(10);
        System.out.println(w.getBalance());
    }
}
