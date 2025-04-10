import Modules.MyArrayList;

public class MyStack<T> {
    private MyArrayList<T> stack;

    public MyStack() {
        stack = new MyArrayList<>();
    }

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T value = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
