package com.problems;

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
//    reverseLinkedList.reverse();
//    reverseLinkedList.reverseWithoutUsingMemory();
    reverseLinkedList.mnReversal(2, 5);
    while (reverseLinkedList.head != null) {
      System.out.println(reverseLinkedList.head.value);
      reverseLinkedList.head = reverseLinkedList.head.next;
    }
  }

  private void reverseWithoutUsingMemory() {
    Node current = this.head;
    Node prev = null;
    while (current != null) {
      Node next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
  }

  // 0-> 1-->2-->3-->4-->5

  private void mnReversal(int m, int n) {
    Node current = this.head;
    Node prev = null;
    int count = 1;
    while (current != null) {
      Node next = current.next;
      System.out.println("next " + next.value);
      if (count >= m) {
        int count1 = count;
        Node current1 = current;
        Node prev1 = null;
        while (current1 != null && count1 <= n) {
          Node next1 = current1.next;
//          System.out.println("next1 " + next1.value);
          current1.next = prev1;
          prev1 = current1;
          System.out.println("prev1 " + prev1.value);
          current1 = next1;
//          System.out.println("current1 " + current1.value);
          count1++;
        }
        current1.next = prev;
        current.next = current1;
        System.out.println("current " + current.value);
        System.out.println("current1 " + current1.value);
      }
      count++;
      prev = current;
      System.out.println("prev " + prev.value);
      current = next;
      System.out.println("current " + current.value);
    }
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
