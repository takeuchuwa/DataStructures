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

    public boolean recursiveContains(T value) {
        return recursiveContains(root, value);
    }

    private boolean recursiveContains(Node<T> currentNode, T value) {
        if (currentNode == null) return false;

        if (currentNode.value.compareTo(value) == 0) return true;

        if (currentNode.value.compareTo(value) > 0) {
            return recursiveContains(currentNode.left, value);
        } else {
            return recursiveContains(currentNode.right, value);
        }
    }

    public void recursiveInsert(T value) {
        if (root == null) root = new Node<>(value);
        recursiveInsert(root, value);
    }

    private Node<T> recursiveInsert(Node<T> currentNode, T value) {
        if (currentNode == null) return new Node<>(value);

        if (currentNode.value.compareTo(value) > 0) {
            currentNode.left = recursiveInsert(currentNode.left, value);
        } else if (currentNode.value.compareTo(value) < 0){
            currentNode.right = recursiveInsert(currentNode.right, value);
        }

        return currentNode;
    }

    private Node<T> deleteNode(Node<T> currentNode, T value) {
        if (currentNode == null) return null;

        if (currentNode.value.compareTo(value) > 0) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (currentNode.value.compareTo(value) < 0){
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left  == null && currentNode.right == null) {
                currentNode = null;
            } else if (currentNode.right == null ) {
                currentNode = currentNode.left;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else {
                T subTreeMinValue = minimumValue(currentNode.right);
                currentNode.value = subTreeMinValue;
                currentNode.right = deleteNode(currentNode.right, subTreeMinValue);
            }

        }

        return currentNode;
    }

    private T minimumValue(Node<T> currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    public void deleteNode(T value) {
        deleteNode(root, value);
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
