package string.practice_problems;

import java.util.*;

public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        return new StringBuilder(customerName).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseCustomerName("Priya Sharma"));
    }
}
