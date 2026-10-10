package oop_introduction_classes_and_objects.assignment;

import java.util.*;

public class ATMPINLengthValidator {
    public static void checkPinLength(String pin) {
        System.out.println(
                pin.length() == 4 ? "PIN length OK." : "Invalid PIN — must be exactly 4 digits.");
    }

    public static void main(String[] args) {
        checkPinLength("4820");
    }
}
