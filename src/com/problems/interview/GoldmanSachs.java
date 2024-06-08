package com.problems.interview;

public class GoldmanSachs {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(4);
        stack.push(2);
        stack.push(3);
//        stack.push(1);
        System.out.println("inspecting value");
        CustomStack.Node node = stack.top;
        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }

//        stack.pop();
//        stack.min;
        System.out.println("run min ");
        System.out.println(stack.min());
    }
}

class CustomStack {

    Node top;
    Node tail;
    int length;
    int min;

    public CustomStack() {
        this.top = null;
        this.tail = null;
        this.length = 0;
        this.min = Integer.MAX_VALUE;
    }

    public void push(int value) {
        Node node = new Node(value);
        System.out.println("pushing value " + value);
        Node top = this.top;
        if (top != null) {
            this.top = node;
            System.out.println("top value" + top.value);
            this.top.next = top;
        } else {
            this.top = node;
            this.tail = node;
            // System.out.println("top value" + top.value);
        }
        System.out.println("tail value" + tail.value);
        this.length++;
    }

// head->4<-2<-3 <-tail

    public int pop() {
        if (this.tail == null) {
            return -1;
        } else {
            Node holdingPoint = this.tail;
            this.tail = this.tail.next;
            this.length--;
            if (holdingPoint.value < min) {
                this.min = holdingPoint.value;
            }
            return holdingPoint.value;

        }

    }

    public int min() {
        int min = Integer.MAX_VALUE;
        Node node = this.top;

        while (node != null) {
            if (node.value < min) {
                System.out.println("new min is " + node.value);
                min = node.value;
            }
            node = node.next;
        }

        System.out.println("return new min is " + min);
        return min;
    }


    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

    }
}
