package com.old.code.dataStructers;

/**
 * Created by Shikhar on 14-02-2019.
 */
public class CustomQueue {
    private Node first;
    private Node last;
    private int length;

    public CustomQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    @Override
    public String toString() {
        return "dataStructers.CustomQueue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
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

    Node peek() {
        return this.first;
    }

    CustomQueue enqueue(String value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            Node last = this.last;
            last.next = newNode;
            this.last = newNode;
        }
        this.length++;
        return this;
    }

    CustomQueue dequeue() {
        if (0 == this.length) {
            return null;
        }
        else if(this.first == this.last){
            this.last=null;
        }
        else {
            this.first = this.first.next;
            this.length--;
        }
        return this;
    }

    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue("1");
        System.out.println(customQueue.peek());
        System.out.println(customQueue.enqueue("2"));
        System.out.println(customQueue.enqueue("3"));
        System.out.println(customQueue.enqueue("4"));
        System.out.println(customQueue.enqueue("5"));
        System.out.println(customQueue.enqueue("6"));
        System.out.println("Dequeue all elements starts");
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
    }
}
