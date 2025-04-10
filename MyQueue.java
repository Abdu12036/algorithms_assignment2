import Modules.MyLinkedList;

public class MyQueue<T> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    public void enqueue(T value) {
        queue.add(value);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T val = queue.get(0);
        queue.remove(0);
        return val;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }
}
