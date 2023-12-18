import java.util.Scanner;

interface SimpleInterest {
    double calculateSimpleInterest(double principal, double rate, double time);
}

interface Circle extends SimpleInterest {
    double calculateCircleArea(double radius);
    double calculateCirclePerimeter(double radius);
}

interface Rectangle extends Circle {
    double calculateRectangleArea(double length, double width);
}

class Calculator implements Rectangle {
    @Override
    public double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    @Override
    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateCirclePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateRectangleArea(double length, double width) {
        return length * width;
    }
}

public class Calic extends Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calic calculator = new Calic();

        // Input for simple interest
        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter interest rate: ");
        double rate = scanner.nextDouble();
        System.out.print("Enter time (in years): ");
        double time = scanner.nextDouble();

        double simpleInterest = calculator.calculateSimpleInterest(principal, rate, time);
        System.out.println("Simple Interest: " + simpleInterest);

        // Input for circle calculations
        System.out.print("Enter radius of the circle: ");
        double radius = scanner.nextDouble();
        double circleArea = calculator.calculateCircleArea(radius);
        System.out.println("Area of Circle: " + circleArea);

        double circlePerimeter = calculator.calculateCirclePerimeter(radius);
        System.out.println("Perimeter of Circle: " + circlePerimeter);

        // Input for rectangle calculations
        System.out.print("Enter length of the rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width of the rectangle: ");
        double width = scanner.nextDouble();

        double rectangleArea = calculator.calculateRectangleArea(length, width);
        System.out.println("Area of Rectangle: " + rectangleArea);

        scanner.close();
    }
}