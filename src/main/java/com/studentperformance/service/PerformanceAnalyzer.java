package com.studentperformance.service;

import com.studentperformance.models.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformanceAnalyzer {

    /**
     * Get top 5 performers (or all if less than 5)
     */
    public List<Student> getToppers(List<Student> students) {
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents);
        return sortedStudents.subList(0, Math.min(5, sortedStudents.size()));
    }

    /**
     * Calculate average marks across all students
     */
    public double getAverageMarks(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.getTotalMarks();
        }
        return sum / students.size();
    }

    /**
     * Calculate average GPA across all students
     */
    public double getAverageGPA(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.getGPA();
        }
        return sum / students.size();
    }

    /**
     * Get highest score among all students
     */
    public double getHighestScore(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }
        double highest = 0;
        for (Student student : students) {
            if (student.getTotalMarks() > highest) {
                highest = student.getTotalMarks();
            }
        }
        return highest;
    }

    /**
     * Get lowest score among all students
     */
    public double getLowestScore(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }
        double lowest = 100;
        for (Student student : students) {
            if (student.getTotalMarks() < lowest) {
                lowest = student.getTotalMarks();
            }
        }
        return lowest;
    }

    /**
     * Count number of students who passed (grade != F)
     */
    public int getPassCount(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            if (!student.getGrade().equals("F")) {
                count++;
            }
        }
        return count;
    }

    /**
     * Count number of students who failed (grade = F)
     */
    public int getFailCount(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            if (student.getGrade().equals("F")) {
                count++;
            }
        }
        return count;
    }

    /**
     * Get performance insights for a student
     */
    public String getPerformanceInsights(Student student) {
        StringBuilder insights = new StringBuilder();
        
        double percentage = student.getPercentage();
        
        if (percentage >= 90) {
            insights.append("Excellent performance! Outstanding academic achievement.");
        } else if (percentage >= 80) {
            insights.append("Very good performance. Strong grasp of concepts.");
        } else if (percentage >= 70) {
            insights.append("Good performance. Satisfactory understanding of subjects.");
        } else if (percentage >= 60) {
            insights.append("Average performance. Need improvement in certain areas.");
        } else if (percentage >= 50) {
            insights.append("Below average performance. Focused effort required to improve.");
        } else {
            insights.append("Poor performance. Intensive support and study needed.");
        }

        // Additional insights based on individual components
        if (student.getCat() < 10) {
            insights.append(" | CAT score needs improvement.");
        }
        if (student.getAssignment() < 10) {
            insights.append(" | Assignment submission quality needs attention.");
        }
        if (student.getFat() < 25) {
            insights.append(" | FAT performance requires focused practice.");
        }

        return insights.toString();
    }
}