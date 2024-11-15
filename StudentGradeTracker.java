import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        String input;
        double sum = 0.0;

        System.out.println("Enter student grades (or type 'done' to finish):");
        
        // Input grades
        while (true) {
            System.out.print("Enter grade: ");
            input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                double grade = Double.parseDouble(input);
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                } else {
                    grades.add(grade);
                    sum += grade;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        
        // Compute and display results if there are any grades entered
        if (grades.size() > 0) {
            double average = sum / grades.size();
            double highest = Collections.max(grades);
            double lowest = Collections.min(grades);
            
            System.out.println("\nResults:");
            System.out.printf("Number of grades entered: %d%n", grades.size());
            System.out.printf("Average grade: %.2f%n", average);
            System.out.printf("Highest grade: %.2f%n", highest);
            System.out.printf("Lowest grade: %.2f%n", lowest);
        } else {
            System.out.println("No grades were entered.");
        }

        scanner.close();
    }
}