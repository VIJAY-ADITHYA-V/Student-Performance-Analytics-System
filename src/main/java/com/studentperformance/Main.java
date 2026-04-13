package com.analytics;

import java.util.Scanner;

public class StudentAnalytics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents = 5;
        String[] names = new String[numStudents];
        double[] totals = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter name for student " + (i + 1) + ":");
            names[i] = sc.next();
            System.out.println("Enter marks (CAT-30, Assignment-20, FAT-50):");
            double cat = sc.nextDouble();
            double assign = sc.nextDouble();
            double fat = sc.nextDouble();
            
            totals[i] = cat + assign + fat;
            String grade = calculateGrade(totals[i]);
            double gpa = (totals[i] / 100.0) * 10.0; // Assuming 10 point scale

            System.out.printf("%s - Total: %.2f, GPA: %.2f, Grade: %s\n", names[i], totals[i], gpa, grade);
        }
        
        // Find Topper
        int topperIndex = 0;
        for(int i=1; i<numStudents; i++) {
            if(totals[i] > totals[topperIndex]) topperIndex = i;
        }
        System.out.println("Topper: " + names[topperIndex] + " with " + totals[topperIndex]);
        sc.close();
    }

    public static String calculateGrade(double marks) {
        if (marks >= 90) return "O";
        else if (marks >= 80) return "A+";
        else if (marks >= 70) return "A";
        else if (marks >= 60) return "B+";
        else if (marks >= 50) return "B";
        else return "F";
    }
}
