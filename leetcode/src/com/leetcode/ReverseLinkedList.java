package com.leetcode;

import java.util.Stack;

public class ReverseLinkedList {

    Node head;

    public ReverseLinkedList(int value) {
        this.head = new Node(value);
    }

    public static void main(String[] args) {
        final ReverseLinkedList reverseLinkedList = new ReverseLinkedList(0);
        reverseLinkedList.push(1);
        reverseLinkedList.push(2);
        reverseLinkedList.push(3);
        reverseLinkedList.reverse();
    }

    private void reverse() {
        Stack<Node> stack = new Stack<>();
        Node head = this.head;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.peek().value + " ");
            stack.pop();
        }
        System.out.println("\n");
    }

    void push(int new_data) {
        Node new_node = new Node(new_data);
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new_node;
    }

    class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
