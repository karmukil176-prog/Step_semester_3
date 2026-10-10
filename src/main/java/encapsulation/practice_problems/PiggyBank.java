package encapsulation.practice_problems;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void deposit(double amount) {
        if (amount > 0) savings += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > savings) return false;
        savings -= amount;
        return true;
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] x) {
        PiggyBank p = new PiggyBank("PB-1");
        p.deposit(100);
        p.withdraw(120);
        System.out.println(p.getSavings());
    }
}
