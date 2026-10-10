package oop_inheritance_and_polymorphism.practice_problems;

public class NicknameTag {
    public static final class NameTag {
        private final String first, lastInitial;

        public NameTag(String n) {
            String[] p = n.split(" ");
            if (p.length != 2) throw new IllegalArgumentException();
            first = p[0];
            lastInitial = p[1].substring(0, 1);
        }

        public String getNickname() {
            return first + " " + lastInitial + ".";
        }
    }

    public static void main(String[] x) {
        System.out.println(new NameTag("Maria Gomez").getNickname());
    }
}
