package oop_introduction_classes_and_objects.class_problems;

import java.util.*;

public class CSVStudentRecordParser {
    public static void parseStudentRecord(String csv) {
        String[] a = csv.split(",", -1);
        if (a.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.printf("Name: %s | Roll Number: %s | Department: %s%n", a[0], a[1], a[2]);
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,101,CSE");
    }
}
