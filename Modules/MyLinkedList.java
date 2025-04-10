package Modules;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    private class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current.prev != null)
                current.prev.next = current.next;
            if (current.next != null)
                current.next.prev = current.prev;
            if (current == tail) tail = current.prev;
        }
        length--;
    }

    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override
    public int size() {
        return length;
    }
}
