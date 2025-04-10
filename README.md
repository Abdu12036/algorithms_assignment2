# Custom Data Structures in Java

This repository contains custom implementations of common data structures in Java using generics. It's designed for educational purposes and helps understand how core data structures work under the hood.

## 📦 Implemented Structures

### 1. `MyArrayList<T>`
A dynamic array that resizes itself when full.
- Supports: `add`, `add(index, element)`, `get`, `remove`, `clear`, `size`
- Internally uses an `Object[]` array and doubles its capacity as needed.

### 2. `MyLinkedList<T>`
A custom doubly linked list implementation.
- Supports: `add`, `get(index)`, `remove(index)`, `clear`, `size`
- Built using inner `MyNode<T>` class with `next` and `prev` references.

### 3. `MyStack<T>`
A stack implementation based on `MyArrayList<T>`.
- Supports typical stack operations: `push`, `pop`, `peek`, `isEmpty`

### 4. `MyQueue<T>`
A queue implementation using `MyLinkedList<T>`.
- Supports: `enqueue`, `dequeue`, `peek`, `isEmpty`

### 5. `MyMinHeap`
A min-heap (priority queue) using `MyArrayList<Integer>`.
- Supports: `add`, `poll`, `peek`
- Maintains the heap property using `heapifyUp` and `heapifyDown`

## 📁 Package Structure

All custom classes are located in the `Modules` package.

## ✅ Requirements

- Java 8 or higher
- No external dependencies

## 🚀 How to Use

Clone the repository and include the classes in your Java project. You can create test classes (e.g., `Main.java`) to try out each structure individually.

```java
MyStack<Integer> stack = new MyStack<>();
stack.push(10);
System.out.println(stack.pop()); // Output: 10
