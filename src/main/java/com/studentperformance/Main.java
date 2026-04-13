package com.studentperformance;

import com.studentperformance.models.Student;
import com.studentperformance.service.PerformanceAnalyzer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

        System.out.println("========================================");
        System.out.println("Student Performance Analytics System");
        System.out.println("========================================\n");

        // Input marks for 5 students
        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Enter details for Student " + i + " ---");
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Student Roll Number: ");
            String rollNumber = scanner.nextLine();

            System.out.print("Enter Student Subject: ");
            String subject = scanner.nextLine();

            System.out.print("Enter CAT Marks (out of 30): ");
            double cat = getValidMarks(scanner, 30);

            System.out.print("Enter Assignment Marks (out of 20): ");
            double assignment = getValidMarks(scanner, 20);

            System.out.print("Enter FAT Marks (out of 50): ");
            double fat = getValidMarks(scanner, 50);

            Student student = new Student(name, rollNumber, subject, cat, assignment, fat);
            students.add(student);
        }

        // Display all students with analysis
        displayAnalysis(students, analyzer);

        scanner.close();
    }

    private static double getValidMarks(Scanner scanner, int maxMarks) {
        double marks = -1;
        while (marks < 0 || marks > maxMarks) {
            try {
                marks = Double.parseDouble(scanner.nextLine());
                if (marks < 0 || marks > maxMarks) {
                    System.out.print("Invalid input! Enter marks between 0 and " + maxMarks + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }
        return marks;
    }

    private static void displayAnalysis(List<Student> students, PerformanceAnalyzer analyzer) {
        System.out.println("\n\n========================================");
        System.out.println("PERFORMANCE ANALYSIS REPORT");
        System.out.println("========================================\n");

        System.out.println("--- Individual Student Details ---\n");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Subject: " + student.getSubject());
            System.out.println("CAT Marks: " + student.getCat() + "/30");
            System.out.println("Assignment Marks: " + student.getAssignment() + "/20");
            System.out.println("FAT Marks: " + student.getFat() + "/50");
            System.out.println("Total Marks: " + student.getTotalMarks() + "/100");
            System.out.println("Percentage: " + String.format("%.2f", student.getPercentage()) + "%");
            System.out.println("GPA: " + String.format("%.2f", student.getGPA()));
            System.out.println("Grade: " + student.getGrade());
            System.out.println("Performance Insights: " + analyzer.getPerformanceInsights(student));
            System.out.println("---");
        }

        System.out.println("\n--- Toppers (Top 5 Students) ---\n");
        List<Student> toppers = analyzer.getToppers(students);
        for (int i = 0; i < toppers.size(); i++) {
            Student topper = toppers.get(i);
            System.out.println((i + 1) + ". " + topper.getName() + " - Total Marks: " + topper.getTotalMarks() +  
                             " | Percentage: " + String.format("%.2f", topper.getPercentage()) + "% | Grade: " + topper.getGrade());
        }

        System.out.println("\n--- Class Statistics ---\n");
        System.out.println("Average Total Marks: " + String.format("%.2f", analyzer.getAverageMarks(students)));
        System.out.println("Average GPA: " + String.format("%.2f", analyzer.getAverageGPA(students)));
        System.out.println("Highest Score: " + analyzer.getHighestScore(students));
        System.out.println("Lowest Score: " + analyzer.getLowestScore(students));
        System.out.println("Pass Count: " + analyzer.getPassCount(students));
        System.out.println("Fail Count: " + analyzer.getFailCount(students));

        System.out.println("\n========================================\n");
    }
}