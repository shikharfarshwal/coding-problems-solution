package com.old.code;

public class LinkedListMiddleElement {

    static class LinkedList {
        Node head; // head of linked list

        /* Linked list node */
        class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        /* Function to print middle element of linked list
         *   In here the head is initialized as a middle element and whenever the count is an odd no we increment
         *   the mid val;ueto the next node in LinkedList.
         * */
        void printMiddleElement() {
            int count = 0;
            Node mid = head;
            while (head != null) {
                if ((count % 2 != 0)) {
                    mid = mid.next;
                }
                ++count;
                head = head.next;
            }
            if (mid != null) {
                System.out.println("The mid element is " + mid.data);
            }
        }

        /* Inserts a new Node at front of the list. */
        public void push(int new_data) {
            Node new_node = new Node(new_data);
            new_node.next = head;
            head = new_node;
        }

        public void printList() {
            Node node = head;
            while (node != null) {
                System.out.print(node.data + "->");
                node = node.next;
            }
            System.out.println("NULL");
        }

    }

    public static void main(String[] args) {
        LinkedList linkedlist = new LinkedList();
        for (int i = 5; i > 0; --i) {
            linkedlist.push(i);
        }
        linkedlist.printList();
        linkedlist.printMiddleElement();
    }

}
