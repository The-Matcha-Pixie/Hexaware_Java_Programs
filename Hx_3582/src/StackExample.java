import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        // Display all elements in the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
