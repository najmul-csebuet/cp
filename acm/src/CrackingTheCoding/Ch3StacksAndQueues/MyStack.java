package CrackingTheCoding.Ch3StacksAndQueues;

import java.util.EmptyStackException;

public class MyStack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    Node<T> top;

    public T pop() {
        if (top == null)
            throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }

    public void push(T data) {
        Node<T> newTop = new Node<>(data);
        newTop.next = top;
        top = newTop;
    }

    public T peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
