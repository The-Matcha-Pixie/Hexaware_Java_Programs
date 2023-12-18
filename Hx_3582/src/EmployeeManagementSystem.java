import java.util.Scanner;

class Employee {
    int eid;
    String ename;
    double basic;
    double hra;
    double ta;
    double da;
    double gross;
    String classification;

    Employee(int eid, String ename, double basic) {
        this.eid = eid;
        this.ename = ename;
        this.basic = basic;
        this.hra = calculateHRA();
        this.ta = calculateTA();
        this.da = calculateDA();
        this.gross = calculateGross();
        this.classification = getClassification();
    }

    double calculateHRA() {
        return 0.12 * basic;
    }

    double calculateTA() {
        return 0.05 * basic;
    }

    double calculateDA() {
        return 0.08 * basic;
    }

    double calculateGross() {
        return basic + hra + ta + da;
    }

    String getClassification() {
        return (gross > 25000) ? "A" : "B";
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input employee details
        System.out.print("Enter employee ID: ");
        int eid = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter employee name: ");
        String ename = scanner.nextLine();
        System.out.print("Enter basic salary: ");
        double basic = scanner.nextDouble();

        // Create employee object
        Employee employee = new Employee(eid, ename, basic);

        // Display details and classification
        System.out.println("Employee ID: " + employee.eid);
        System.out.println("Employee Name: " + employee.ename);
        System.out.println("Basic Salary: " + employee.basic);
        System.out.println("HRA: " + employee.hra);
        System.out.println("TA: " + employee.ta);
        System.out.println("DA: " + employee.da);
        System.out.println("Gross Salary: " + employee.gross);
        System.out.println("Classification: " + employee.classification);

        scanner.close();
    }
}