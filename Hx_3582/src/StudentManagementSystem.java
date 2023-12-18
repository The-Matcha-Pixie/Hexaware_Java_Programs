import java.util.Scanner;

class Stud {
    int sid;
    String sname;
    double m1, m2, m3;
    double total;
    double average;
    String classification;

    Stud(int sid, String sname, double m1, double m2, double m3) {
        this.sid = sid;
        this.sname = sname;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.total = calculateTotal();
        this.average = calculateAverage();
        this.classification = getClassification();
    }

    double calculateTotal() {
        return m1 + m2 + m3;
    }

    double calculateAverage() {
        return calculateTotal() / 3;
    }

    String getClassification() {
        double average = calculateAverage();
        if (average > 60) {
            return "1st Class";
        } else if (average >= 50 && average <= 60) {
            return "2nd Class";
        } else {
            return "3rd Class";
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input student details
        System.out.print("Enter student ID: ");
        int sid = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter student name: ");
        String sname = scanner.nextLine();
        System.out.print("Enter marks for subject 1: ");
        double m1 = scanner.nextDouble();
        System.out.print("Enter marks for subject 2: ");
        double m2 = scanner.nextDouble();
        System.out.print("Enter marks for subject 3: ");
        double m3 = scanner.nextDouble();

        // Create student object
        Stud student = new Stud(sid, sname, m1, m2, m3);

        // Display total, average, and classification
        System.out.println("Total marks: " + student.total);
        System.out.println("Average marks: " + student.average);
        System.out.println("Classification: " + student.classification);

        scanner.close();
    }
}