package com.horban.study;

public class Stack<T> {
    private Node<T> top;

    private int height;

    public Stack() {}

    public Stack(T value) {
        top = new Node<>(value);
        height = 1;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (height != 0) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    public Node<T> pop() {
        Node<T> popElement = top;
        if (height > 0) {
            top = top.next;
            popElement.next = null;
            height--;
        }

        return popElement;
    }

    public Node<T> getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node<T> temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public Node<T> peek() {
        return top;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
