package Modules;

// A generic node class
public class MyNode<T> {
    T data;
    MyNode<T> next;

    // initializes the node with given data
    public MyNode(T data){
        this.data = data;
    }
}
