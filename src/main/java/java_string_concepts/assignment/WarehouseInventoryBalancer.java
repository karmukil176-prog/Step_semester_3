package java_string_concepts.assignment;


public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] a, int[] b) {
        if (a.length != b.length || a.length == 0)
            throw new IllegalArgumentException("Arrays must have equal nonzero length");
        long sa = 0, sb = 0;
        for (int x : a) sa += x;
        for (int x : b) sb += x;
        int max = a[0], idx = 0;
        char section = 'A';
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                idx = i;
                section = 'A';
            }
            if (b[i] > max) {
                max = b[i];
                idx = i;
                section = 'B';
            }
        }
        System.out.printf(
                "Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d"
                    + " (Section %c, Item %d)%n",
                sa, sb, sa == sb ? "Balanced" : "Not Balanced", max, section, idx + 1);
    }

    public static void main(String[] args) {
        analyzeInventory(new int[] {20, 15, 30}, new int[] {25, 10, 30});
    }
}
