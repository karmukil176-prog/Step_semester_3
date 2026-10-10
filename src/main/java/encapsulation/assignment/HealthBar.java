package encapsulation.assignment;

public class HealthBar {
    public static class Character {
        private int health;
        private final int maxHealth;

        public Character(int m) {
            if (m < 0) throw new IllegalArgumentException();
            maxHealth = m;
            health = m;
        }

        public void takeDamage(int n) {
            if (n > 0) health = (int) Math.max(0L, (long) health - n);
        }

        public void heal(int n) {
            if (n > 0) health = (int) Math.min(maxHealth, (long) health + n);
        }

        public int getHealth() {
            return health;
        }
    }

    public static void main(String[] x) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
        System.out.println(c.getHealth());
    }
}
