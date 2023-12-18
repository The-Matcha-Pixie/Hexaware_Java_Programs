import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100); // Generates a random number between 0 (inclusive) and 100 (exclusive)
        System.out.println("Random Number: " + randomNumber);
    }
}
