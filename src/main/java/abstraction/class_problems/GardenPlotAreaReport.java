package abstraction.class_problems;

import java.util.*;

public class GardenPlotAreaReport {
    private interface Area {
        double area();
        String owner();
        String shape();
    }
    private record Circle(String owner, double radius) implements Area {
        public double area() {
            return Math.PI * radius * radius;
        }
        public String shape() {
            return "CIRCLE";
        }
    }
    private record Rectangle(String owner, double length, double width) implements Area {
        public double area() {
            return length * width;
        }
        public String shape() {
            return "RECTANGLE";
        }
    }
    private record Triangle(String owner, double base, double height) implements Area {
        public double area() {
            return .5 * base * height;
        }
        public String shape() {
            return "TRIANGLE";
        }
    }
    private static Scanner in() {
        return new Scanner(System.in);
    }
    public static void plots() {
        Scanner s = in();
        int n = s.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            String type = s.next(), owner = s.next();
            Area a = switch (type) {
                case "CIRCLE" -> new Circle(owner, s.nextDouble());
                case "RECTANGLE" -> new Rectangle(owner, s.nextDouble(), s.nextDouble());
                case "TRIANGLE" -> new Triangle(owner, s.nextDouble(), s.nextDouble());
                default -> throw new IllegalArgumentException("Unknown shape");
            };
            sum += a.area();
            System.out.printf("%s (%s): %.2f%n", a.owner(), a.shape(), a.area());
        }
        System.out.printf("Total Area: %.2f%n", sum);
    }
    public static void main(String[] args) {
        plots();
    }
}
