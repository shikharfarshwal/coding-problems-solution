package com.problems.striver;

public class MinStackUsingPair {

    Node top;
    Integer min;

    MinStackUsingPair() {
        this.top = null;
        this.min = null;
    }

    public static class PairStack {
        int actVal;
        int minVal;

        PairStack(int actVal, int minVal) {
            this.actVal = actVal;
            this.minVal = minVal;
        }
    }

    public static class Node {
        Node next;
        PairStack pairStack;

        Node(PairStack ps) {
            this.pairStack = ps;
        }
    }

    public void push(int val) {
        Node node = this.top;
        if (node == null) {
            PairStack ps = new PairStack(val, val);
            node = new Node(ps);
            this.min = val;
            this.top = node;
        } else {
            Node topNode = this.top;
            int min = topNode.pairStack.minVal;
            PairStack ps = null;
            if (val < min) {
                ps = new PairStack(val, val);
                this.min = val;
            } else {
                ps = new PairStack(val, min);
            }
            Node newNode = new Node(ps);
            newNode.next = node;
            this.top = newNode;
        }
    }

    public Integer top() {
        return this.top == null ? null : this.top.pairStack.actVal;
    }

    public Integer getMin() {
        return this.min == null ? null : this.min;
    }

    public int pop() {
        if (this.top == null) {
            return -1;
        } else {
            Node node = this.top;
            this.top = node.next;
            this.min = this.top == null ? null : this.top.pairStack.minVal;
            return node.pairStack.actVal;
        }
    }





/*
["MinStack","push","push","push","getMin","pop","top","getMin"]
[null,null,null,null,-3,null,-2,-2]
 */
    public static void main(String[] args) {
        MinStackUsingPair minStackUsingPair = new MinStackUsingPair();
        minStackUsingPair.push(-3);
        System.out.println("current minVal is : { " + minStackUsingPair.getMin()); // return -3
       /* minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("-----print stack------");
        printStack(minStack);
        System.out.println("current minVal is : { " + minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("-----print stack------");
        printStack(minStack);
        minStack.top();    // return 0
        minStack.getMin();*/



    }

    /*public static void main(String[] args) {
        MinStack minStack = new MinStack();
        System.out.println("-----push------");
        minStack.push(12);
        System.out.println("current minVal is : { " + minStack.top());
        minStack.push(15);
        System.out.println("current minVal is : { " + minStack.top());
        minStack.push(10);
        System.out.println("-----print stack------");
        printStack(minStack);
        System.out.println("top element is " + minStack.top.pairStack.actVal);
        System.out.println("current minVal is : { " + minStack.top());
        System.out.println("-----pop------");
        System.out.println("popped {} - " + minStack.pop());
        System.out.println("current minVal is : { " + minStack.getMin());
        System.out.println("current top minVal is : { " + minStack.top());
        System.out.println("popped {} - " + minStack.pop());
        System.out.println("-----print stack------");
        printStack(minStack);
        System.out.println("current minVal is : { " + minStack.getMin());
        System.out.println("current top minVal is : { " + minStack.top());
        System.out.println("popped {} - " + minStack.pop());
        System.out.println("current minVal is : { " + minStack.getMin());
        System.out.println("current top minVal is : { " + minStack.top());
        System.out.println("-----push------");
        minStack.push(12);
        minStack.push(15);
        minStack.push(10);
        System.out.println("-----print stack------");
        printStack(minStack);
        System.out.println("current minVal is : { " + minStack.getMin());
        System.out.println("current top minVal is : { " + minStack.top());
    }*/

    private static void printStack(MinStackUsingPair minStackUsingPair) {
        MinStackUsingPair.Node top = minStackUsingPair.top;
        while (top != null) {
            System.out.println("actVal : { " + top.pairStack.actVal + "} minVal : { " + top.pairStack.minVal + " }");
            top = top.next;
        }
    }
}
