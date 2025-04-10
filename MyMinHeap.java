import Modules.MyArrayList;

// implementation of a Min-Heap using MyArrayList
public class MyMinHeap {
    private MyArrayList<Integer> heap; // Internal storage for heap elements

    // Constructor: initializes an empty heap
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Adds a new value to the heap
    public void add(int value) {
        heap.add(value);                  // Add to the end
        heapifyUp(heap.size() - 1); // Restore heap property upwards
    }

    // Removes and returns the smallest element
    public int poll() {
        if (heap.size() == 0)
            throw new RuntimeException("Heap is empty");

        int min = heap.get(0);            // Save the minimum element
        heap.remove(0);              // Remove root

        // If there are still elements, restore heap structure
        if (heap.size() > 0) {
            heap.add(0, heap.get(heap.size() - 1)); // Move last to root
            heap.remove(heap.size() - 1);           // Remove duplicate
            heapifyDown(0);                         // Restore heap property downwards
        }
        return min;
    }

    // Returns the smallest element without removing it
    public int peek() {
        if (heap.size() == 0)
            throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    // Moves the element at index up to maintain the heap property
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) < heap.get(parent)) {
                int temp = heap.get(index);
                heap.elements[index] = heap.get(parent);
                heap.elements[parent] = temp;
                index = parent;
            } else break;
        }
    }

    // Moves the element at index down to maintain the heap property
    private void heapifyDown(int index) {
        int left, right, smallest;
        while (index < heap.size()) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                int temp = heap.get(index);
                heap.elements[index] = heap.get(smallest);
                heap.elements[smallest] = temp;
                index = smallest;
            } else break;
        }
    }
}
