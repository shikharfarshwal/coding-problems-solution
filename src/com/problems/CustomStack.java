package com.problems;

public class CustomStack {

    Node top;

    public static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    public void push(int val) {
        Node node = this.top;
        if (node == null) {
            node = new Node(val);
            this.top = node;
        } else {
            Node newNode = new Node(val);
            newNode.next = node;
            this.top = newNode;
        }
    }

    public int pop() {
        if (this.top == null) {
            return -1;
        } else {
            Node node = this.top;
            this.top = node.next;
            return node.val;
        }
    }


    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        System.out.println("-----push------");
        customStack.push(12);
        customStack.push(15);
        customStack.push(10);
        System.out.println("-----print stack------");
        printStack(customStack);
        System.out.println("-----pop------");
        System.out.println("popped {} - " + customStack.pop());
        System.out.println("popped {} - " + customStack.pop());
        System.out.println("-----print stack------");
        printStack(customStack);
        System.out.println("-----push------");
        customStack.push(15);
        customStack.push(10);
        System.out.println("-----print stack------");
        printStack(customStack);
    }

    private static void printStack(CustomStack customStack) {
        Node top = customStack.top;
        while (top != null) {
            System.out.println(top.val);
            top = top.next;
        }
    }
}
