package com.horban.study;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public DoubleLinkedList(T value) {
        createFirst(value);
    }

    private void createFirst(T value) {
        Node<T> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(T value) {
        if (length == 0) {
            createFirst(value);
            return;
        }

        Node<T> newNode = new Node<>(value);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        length++;
    }

    public Node<T> removeLast() {
        Node<T> removedNode = tail;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> newTail = tail.prev;
            newTail.next = null;
            tail = newTail;
            removedNode.prev = null;
        }

        length--;
        return removedNode;
    }

    public void prepend(T value) {
        if (length == 0) {
            createFirst(value);
        } else {
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node<T> removeFirst() {
        Node<T> removedNode = head;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = removedNode.next;
            head.prev = null;
            removedNode.next = null;
        }
        length--;
        return removedNode;
    }

    public Node<T> get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index >= length) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> nodeAtIndex;
        if (index < length / 2) {
            nodeAtIndex = head;
            int currentElement = 0;
            while (index != currentElement) {
                nodeAtIndex = nodeAtIndex.next;
                currentElement++;
            }
        } else {
            nodeAtIndex = tail;
            int currentElement = length - 1;
            while (index != currentElement) {
                nodeAtIndex = nodeAtIndex.prev;
                currentElement--;
            }
        }

        return nodeAtIndex;
    }

    public boolean insert(int index, T value) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index > length) {
            throw new IndexOutOfBoundsException();
        }

        if (index == length) {
            append(value);
        } else if (index == 0) {
            prepend(value);
        } else {
            Node<T> prevNode = get(index - 1);
            Node<T> nextNode = prevNode.next;
            Node<T> newNode = new Node<>(value);
            newNode.next = nextNode;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            nextNode.prev = newNode;
            length++;
        }
        return true;
    }

    public Node<T> remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        }
        Node<T> prevNode = get(index - 1);
        Node<T> removedNode = prevNode.next;
        Node<T> nextNode = removedNode.next;
        prevNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        removedNode.next = null;
        removedNode.prev = null;
        length--;
        return removedNode;
    }

    public void swapFirstLast() {
        if (head == null || head == tail) {
            return;
        }

        Node<T> nextNode = head.next;
        Node<T> prevNode = tail.prev;
        if (length > 2) {
            nextNode.prev = tail;
            prevNode.next = head;
            head.prev = prevNode;
            tail.next = nextNode;
        }
        Node<T> tmpHead = head;
        head = tail;
        tail = tmpHead;
        if (head.next == null) {
            head.next = tmpHead;
            tmpHead.prev = head;
        }
        head.prev = null;
        tail.next = null;

    }

    public boolean set(int index, T value) {
        Node<T> tNode = get(index);
        tNode.value = value;
        return true;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }
    }
}
