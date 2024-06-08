package com.old.code.dataStructers; /**
 * Created by Shikhar on 13-02-2019.
 */

/**
 * Custom Stack with linked list as the storing DS.
 */
public class CustomStack {
    private int length;
    private Node top;
    private Node bottom;

    @Override
    public String toString() {
        return "dataStructers.CustomStack{" +
                "length=" + length +
                ", top=" + top +
                ", bottom=" + bottom +
                '}';
    }

    public CustomStack() {
        this.length = 0;
        this.top = null;
        this.bottom = null;
    }

    class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    public Node peek() {
        return this.top;
    }

    /**
     * Push into the stack.
     *
     * @param value
     */
    public CustomStack push(String value) {
        Node newNode = new Node(value);
        Node top = this.top;
        if (top != null) {
            this.top = newNode;
            System.out.println("next is "+this.top.next);
            this.top.next = top;
            System.out.println("next is "+this.top.next);
        } else {
            this.top = newNode;
            this.bottom = newNode;
        }
        this.length++;
        return this;
    }

    /**
     * Pop from the stack.
     */
    public Node pop() {
        if (null == top) {
            System.out.println("No element to be poped");
            return null;
        } else {
            Node holdingPointer = this.top;
            this.top = this.top.next;
            this.length--;
            return holdingPointer;
        }
    }





    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push("udemy");
        customStack.push("discord");
        customStack.push("SHIKHAR");
        System.out.println(customStack.push("LIPI"));
        System.out.println("Popped element is "+ customStack.pop());
        System.out.println(customStack);
    }
}


