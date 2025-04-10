package Modules;

// A custom generic doubly linked list implementing MyList interface
public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;  // First node in the list
    private MyNode<T> tail;  // Last node in the list
    private int length;      // Current size of the list

    // initializes an empty list
    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    // Inner class representing a node in a doubly linked list
    private class MyNode<T> {
        T data;            // Data held by the node
        MyNode<T> next;    // Reference to the next node
        MyNode<T> prev;    // Reference to the previous node

        MyNode(T data) {
            this.data = data;
        }
    }

    // Adds an element to the end of the list
    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {               // List is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;         // Append to the end
            newNode.prev = tail;
            tail = newNode;              // Update the tail
        }
        length++;
    }

    // Returns the element at the specified index
    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Removes the element at the specified index
    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> current = head;

        // Special case: removing the first element
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
        } else {
            // Traverse to the node at the given index
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            // Remove the current node
            if (current.prev != null)
                current.prev.next = current.next;
            if (current.next != null)
                current.next.prev = current.prev;
            if (current == tail)
                tail = current.prev;
        }

        length--;
    }

    // Clears the entire list
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    // Throws exception if index is out of valid range
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    // Returns the number of elements in the list
    @Override
    public int size() {
        return length;
    }
}
