package oop_inheritance_and_polymorphism.assigment_problems;

public class TrafficLight {
    private static final String[] C = {"RED", "GREEN", "YELLOW"};
    private final String id;
    private int index;

    public TrafficLight(String id) {
        this.id = id;
    }

    public String getColor() {
        return C[index];
    }

    public String getId() {
        return id;
    }

    public void next() {
        index = (index + 1) % 3;
    }

    public static void main(String[] x) {
        TrafficLight t = new TrafficLight("TL-9");
        for (int i = 0; i < 4; i++) {
            System.out.println(t.getColor());
            t.next();
        }
    }
}
