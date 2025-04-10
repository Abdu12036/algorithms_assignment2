import Modules.MyArrayList;

// A custom generic stack implementation using MyArrayList
public class MyStack<T> {
    private MyArrayList<T> stack; // Internal storage for stack elements

    // Constructor: initializes an empty stack
    public MyStack() {
        stack = new MyArrayList<>();
    }

    // Pushes an element onto the top of the stack
    public void push(T value) {
        stack.add(value);
    }

    // Removes and returns the top element of the stack
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T value = stack.get(stack.size() - 1); // Get top element
        stack.remove(stack.size() - 1);        // Remove it
        return value;
    }

    // Returns the top element without removing it
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack.get(stack.size() - 1);
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
