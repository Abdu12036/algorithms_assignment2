import Modules.MyLinkedList;

// A custom generic queue implementation using MyLinkedList
public class MyQueue<T> {
    private MyLinkedList<T> queue; // Internal storage for queue elements

    // initializes an empty queue
    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    // Adds an element to the end of the queue
    public void enqueue(T value) {
        queue.add(value);
    }

    // Removes and returns the front element of the queue
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T val = queue.get(0);  // Get the front element
        queue.remove(0);       // Remove it from the front
        return val;
    }

    // Returns the front element without removing it
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return queue.get(0);
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return queue.size() == 0;
    }
}
