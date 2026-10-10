package string_operations_and_perfomance.assignment_problems;

import java.util.*;

public class ATMPINLengthValidator {
    public static void checkPinLength(String pin) {
        System.out.println(pin.length() == 4 ? "PIN length OK." : "Invalid PIN — must be exactly 4 digits.");
    }
    public static void main(String[] args) {
        checkPinLength("4820");
    }
}
