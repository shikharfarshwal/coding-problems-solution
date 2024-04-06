package com.old.code.dataStructers;

/**
 * Created by Shikhar on 08-02-2019.
 */
public class CustomDoublyLinkedList {

    private Node head;
    private Node tail;
    int length;

    @Override
    public String toString() {
        return "dataStructers.CustomDoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    CustomDoublyLinkedList(String value) {
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }

    private class Node {
        String value;
        Node next;
        Node prev;

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }

        Node(String value) {
            this.value = value;
            this.next = null;
            this.prev=null;
        }
    }

    CustomDoublyLinkedList append(String value){
        Node newNode = new Node(value);
        newNode.prev=this.tail;
        Node tail = this.tail;
        tail.next = newNode;
        this.length++;
        this.tail =newNode;
        return this;
    }

    /**
     * This function will append a new node to a linked list without using tail.
     *
     * @param value
     */
    public CustomDoublyLinkedList appendL(String value) {
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(value);
        current.next = newNode;
        newNode.prev=current;
        this.length++;
        this.tail = null;
        return this;
    }

    public static void main(String[] args) {
        CustomDoublyLinkedList doublyLinkedList = new CustomDoublyLinkedList("1");
        System.out.println(doublyLinkedList);
        System.out.println(doublyLinkedList.appendL("2"));
        System.out.println(doublyLinkedList.append("3"));
        System.out.println(doublyLinkedList.append("4"));
        System.out.println(doublyLinkedList.append("5"));
    }
}
