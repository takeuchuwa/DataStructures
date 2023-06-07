package com.horban.study;

public class Queue<T> {

    private Node<T> first;

    private Node<T> last;

    private int length;

    public Queue(T value) {
        Node<T> newNode = new Node<>(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public Node<T> dequeue() {
        Node<T> removedNode = first;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            first = null;
            last = null;
        } else {
            first = removedNode.next;
            removedNode.next = null;
        }
        length--;
        return removedNode;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node<T> temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
