package access_modifiers_encapsulation_object_modeling.class_problems;

public class StudentPlacementRecordManagement {
    public static class PlacementRecord {
        private final String studentName, company;
        private final double packageLpa;

        public PlacementRecord(String n, String c, double p) {
            studentName = n;
            company = c;
            packageLpa = p;
        }

        public void printRecord() {
            System.out.printf("%s -> %s @ %.1f LPA%n", studentName, company, packageLpa);
        }
    }

    public static void main(String[] x) {
        new PlacementRecord("Ravi", "TCS", 4.5).printRecord();
        new PlacementRecord("Anitha", "Zoho", 6.2).printRecord();
        new PlacementRecord("Karthik", "Infosys", 4).printRecord();
    }
}
