import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Sabrina {
    private String name;
    private int age;

    public Sabrina(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Sabrina{name='" + name + "', age=" + age + '}';
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Sabrina> people = new ArrayList<>();
        people.add(new Sabrina("Alice", 25));
        people.add(new Sabrina("Bob", 30));
        people.add(new Sabrina("Charlie", 22));

        // Sort the list of people based on age (using Comparator)
        Collections.sort(people, Comparator.comparingInt(Sabrina::getAge));

        // Display all people after sorting
        System.out.println("people after sorting: " + people);
    }
}
