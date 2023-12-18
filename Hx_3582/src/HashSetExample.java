import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Blue");

        // Display all elements in the hash set
        System.out.println("HashSet: " + hashSet);
    }
}
