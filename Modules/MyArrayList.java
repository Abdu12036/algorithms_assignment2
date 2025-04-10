package Modules;

// A custom generic ArrayList implementation with dynamic resizing
public class MyArrayList<T> implements MyList<T> {
    public Object[] elements; // Array to store the elements
    private int length;       // Current number of elements in the list

    // Constructor: initializes the array with a default capacity
    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    // Adds an element to the end of the list
    public void add(T element) {
        if (length == elements.length) {
            increaseCapacity(); // Double the capacity if array is full
        }
        elements[length++] = element;
    }

    // Inserts an element at a specific index
    public void add(int index, T element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        if (length == elements.length) {
            increaseCapacity(); // Ensure there is room to insert
        }

        // Shift elements to the right to make space
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        length++;
    }

    // Doubles the capacity of the internal array
    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    // Retrieves the element at the specified index
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Removes the element at the specified index
    public void remove(int index) {
        checkIndex(index);
        // Shift elements to the left to fill the gap
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--length] = null; // Clear the last element
    }

    // Clears all elements from the list
    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }

    // Checks if the index is within valid bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    // Returns the number of elements in the list
    public int size() {
        return length;
    }
}
