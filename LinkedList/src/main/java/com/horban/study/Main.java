package com.horban.study;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> myLinkedList = new LinkedList<>(4);

        myLinkedList.append(3);
        myLinkedList.append(34);
        myLinkedList.append(86);
        myLinkedList.reverse();
        myLinkedList.get(2);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Head: 4
            Tail: 4
            Length: 1

            Linked List:
            4

        */

    }

}
