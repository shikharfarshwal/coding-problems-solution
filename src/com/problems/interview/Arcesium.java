package com.problems.interview;


import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to get last n songs
 * Write a program to fetch top n songs
 * <p>
 * <p>
 * What i did was created a doubly linked list and added songs to the head pointer
 * then created one function to get last n songs by iterating -- from the tail pointer till nth song and adding it to the list and
 * then returnign the list .
 * i got stuck in the implementation part where i was intializing the node
 */
public class Arcesium {

    public static void main(String[] args) {
        DoublyLinkedList.Node node = new DoublyLinkedList.Node("A");
        DoublyLinkedList ll = new DoublyLinkedList(node);
        ll.appendNode(getNode("B"));
        ll.appendNode(getNode("C"));
        ll.appendNode(getNode("A"));
        ll.appendNode(getNode("B"));
        ll.appendNode(getNode("D"));
        List<String> lastNSongs = ll.getLastNSongs(3);
        lastNSongs.forEach(System.out::println);
    }


    public static DoublyLinkedList.Node getNode(String value){
        return new DoublyLinkedList.Node(value);
    }
}


class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList(Node node) {
        this.head = node;
        this.tail = this.head;
    }


    public List<String> getLastNSongs(int n) {
        List<String> songs = new ArrayList();
        int count = 0;
        Node temp = this.tail;
        while (count < n) {
            songs.add(temp.value);
            temp = temp.prev;
            count++;
        }
        return songs;
    }

    // 1 -> 2 -> 3
    public void appendNode(Node newNode) {
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        newNode.prev = node;
        this.tail = newNode;
    }

    public static class Node {
        Node next;
        Node prev;
        String value;


        public Node(String value) {
            this.next = null;
            this.prev = null;
            this.value = value;
        }
    }
}
