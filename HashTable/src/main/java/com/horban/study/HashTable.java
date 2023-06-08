package com.horban.study;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K extends Comparable<K>, V> {

    private static int defaultSize = 7;
    private Node<K, V>[] dataMap;

    public HashTable() {
        dataMap = new Node[defaultSize];
    }

    public void set(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node<K, V> temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> valueNode = dataMap[index];
        while (valueNode != null) {
            if (valueNode.key == key || valueNode.key.equals(key)) {
                return valueNode.value;
            }
            valueNode = valueNode.next;
        }

        return null;
    }

    public List<K> keys() {
        List<K> allKeys = new ArrayList<>();
        for (Node<K, V> temp : dataMap) {
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }

        return allKeys;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if (dataMap[i] != null) {
                Node<K, V> temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() * 24) % dataMap.length;
    }

    static class Node<K extends Comparable<K>, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
