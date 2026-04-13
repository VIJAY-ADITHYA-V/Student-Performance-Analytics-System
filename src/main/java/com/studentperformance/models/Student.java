package com.studentperformance.models;

public class Student implements Comparable<Student> {
    private String name;
    private String rollNumber;
    private String subject;
    private double cat;           // Out of 30
    private double assignment;    // Out of 20
    private double fat;           // Out of 50
    private double totalMarks;
    private double percentage;
    private double gpa;
    private String grade;

    public Student(String name, String rollNumber, String subject, 
                   double cat, double assignment, double fat) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subject = subject;
        this.cat = cat;
        this.assignment = assignment;
        this.fat = fat;
        calculateMetrics();
    }

    private void calculateMetrics() {
        // Calculate total marks (out of 100)
        this.totalMarks = cat + assignment + fat;

        // Calculate percentage
        this.percentage = (totalMarks / 100) * 100;

        // Calculate GPA (out of 4.0)
        this.gpa = calculateGPA();

        // Assign grade
        this.grade = assignGrade();
    }

    private double calculateGPA() {
        // GPA Calculation based on percentage
        if (percentage >= 90) {
            return 4.0;
        } else if (percentage >= 80) {
            return 3.5;
        } else if (percentage >= 70) {
            return 3.0;
        } else if (percentage >= 60) {
            return 2.5;
        } else if (percentage >= 50) {
            return 2.0;
        } else {
            return 0.0;
        }
    }

    private String assignGrade() {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public int compareTo(Student other) {
        // Sort in descending order of total marks
        return Double.compare(other.totalMarks, this.totalMarks);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getSubject() {
        return subject;
    }

    public double getCat() {
        return cat;
    }

    public double getAssignment() {
        return assignment;
    }

    public double getFat() {
        return fat;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getGPA() {
        return gpa;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", subject='" + subject + '\'' +
                ", totalMarks=" + totalMarks +
                ", percentage=" + percentage +
                ", gpa=" + gpa +
                ", grade='" + grade + '\'' +
                '}';
    }
}