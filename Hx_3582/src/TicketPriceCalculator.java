import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TicketPriceCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSeats = 100;
        int basePrice = 500;
        int[] vendor_seats = new int[4];
        int[] booked_seats = new int[4];
        double[] vendor_charges = new double[4];

        vendor_seats[1] = (int) (0.1 * totalSeats);
        vendor_seats[2] = (int) (0.05 * totalSeats);
        vendor_seats[3] = (int) (0.12 * totalSeats);
        vendor_seats[0] = totalSeats - (vendor_seats[1] + vendor_seats[2] + vendor_seats[3]);

        booked_seats[0] = 0;
        booked_seats[1] = 0;
        booked_seats[2] = 0;
        booked_seats[3] = 0;

        vendor_charges[0] = 1;
        vendor_charges[1] = 1.05;
        vendor_charges[2] = 1.03;
        vendor_charges[3] = 1.09;


        while (true) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your date of birth (DD-MM-YYYY): ");
            String dob = scanner.nextLine();

            System.out.print("Enter your gender (M/F): ");
            char gender = scanner.next().charAt(0);

            System.out.print("Enter the vendor number (1/2/3). Enter 0 for Direct Booking: ");
            int vendor = scanner.nextInt();

            System.out.print("Enter the number of seats you wish to book: ");
            int seatsToBook = scanner.nextInt();
            scanner.nextLine();

            if (seatsToBook > vendor_seats[vendor] - booked_seats[vendor]) {
                System.out.println("Sorry, only "+(vendor_seats[vendor] - booked_seats[vendor]) +" seats available. Try again.");
                continue;
            }

            double totalPrice = basePrice * seatsToBook;

            if (calculateAge(dob) > 60) {
                totalPrice *= 0.9; // 10% concession for age > 60
                System.out.println("Senior Citizen Concession of 10% applied.");
            }

            if (gender == 'F' || gender == 'f') {
                totalPrice *= 0.853; // 14.7% concession for females
                System.out.println("Female Concession of 14.7% applied.");
            }

            double bookedSeatsPercentage = (double) booked_seats[vendor] / vendor_seats[vendor];

            if (bookedSeatsPercentage >= 0.5 && bookedSeatsPercentage <= 0.75) {
                totalPrice *= 1.18; // 18% surcharge for 50-75% booked seats
                System.out.println("Surcharge of 18% applied limited seat availability.");
            } else if (bookedSeatsPercentage > 0.75) {
                totalPrice *= 1.32; // 32% surcharge for >75% booked seats
                System.out.println("Surcharge of 32% applied due to very limited seat availability.");
            }

            totalPrice *= vendor_charges[vendor];
            System.out.println("Vendor Fees of "+ (int) ((vendor_charges[vendor]-1)*100) +"% applied.");


            booked_seats[vendor] += seatsToBook;

            System.out.println();
            System.out.println("Name: " + name);
            System.out.println("Date of Birth: " + dob);
            System.out.println("Gender: " + gender);
            System.out.println("Vendor: " + vendor);
            System.out.println("Number of seats to be booked: " + seatsToBook);
            System.out.println("Total price: Rs." + totalPrice);

            System.out.print("Do you want to make another booking? (Y/N): ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();

            if (choice != 'Y' && choice != 'y') {
                System.out.println("Exiting...");
                break;
            }
        }

        scanner.close();
    }


    private static int calculateAge(String dobString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date dob = dateFormat.parse(dobString);
            Date currentDate = new Date();
            long ageInMillis = currentDate.getTime() - dob.getTime();
            return (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

}
}
