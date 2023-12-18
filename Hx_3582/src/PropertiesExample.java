import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("username", "john_doe");
        properties.setProperty("password", "secure123");

        // Display all properties
        System.out.println("Properties: " + properties);
    }
}
