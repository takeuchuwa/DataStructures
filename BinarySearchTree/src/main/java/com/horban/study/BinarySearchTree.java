package com.horban.study;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public boolean insert(T value) {
        if (value == null) return false;

        Node<T> newNode = new Node<>(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node<T> currentNode = root;
        while (true) {
            if (currentNode.value.compareTo(value) == 0) {
                return false;
            } else if (currentNode.value.compareTo(value) > 0) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return true;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return true;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public boolean contains(T value) {
        if (root == null) return false;
        Node<T> currentNode = root;
        while (currentNode != null) {
            if (currentNode.value.compareTo(value) == 0) {
                return true;
            } else if (currentNode.value.compareTo(value) > 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return false;
    }

    public Node<T> getRoot() {
        return root;
    }

    static class Node<T extends Comparable<T>> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }
    }
}
