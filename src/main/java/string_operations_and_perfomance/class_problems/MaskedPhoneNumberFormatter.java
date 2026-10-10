package string_operations_and_perfomance.class_problems;

import java.util.*;

public class MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.chars().allMatch(Character::isDigit)) return "Invalid phone number";
        return new StringBuilder(phone).replace(0, 6, "XXXXXX").insert(6, '-').toString();
    }
    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
    }
}
