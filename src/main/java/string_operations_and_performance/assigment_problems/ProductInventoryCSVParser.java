package string_operations_and_performance.assigment_problems;

import java.util.*;

public class ProductInventoryCSVParser {
    public static void parseInventoryRecord(String line) {
        String[] f = line.split(",", -1);
        if (f.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", f[0], f[1], f[2]);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
    }
}
