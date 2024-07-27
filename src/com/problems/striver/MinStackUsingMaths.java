package com.problems.striver;

public class MinStackUsingMaths {

    Node top;
    Integer min;

    MinStackUsingMaths() {
        this.top = null;
        this.min = null;
    }

    public static class Node {
        Node next;
        int actVal;

        Node(int actVal) {
            this.actVal = actVal;
        }
    }

    public void push(int val) {
        Node node = this.top;
        if (node == null) {
            node = new Node(val);
            this.min = val;
            this.top = node;
        } else if (val < this.min) {
            int newVal = 2 * val - this.min;
            Node newNode = new Node(newVal);
            newNode.next = node;
            this.top = newNode;
            this.min = val;
        } else {
            Node newNode = new Node(val);
            newNode.next = node;
            this.top = newNode;
        }
    }

    public Integer top() {
        return this.top == null ? null : this.top.actVal;
    }

    public Integer getMin() {
        return this.min;
    }

    public Integer pop() {
        Node topNode = this.top;
        if (topNode == null) {
            return null;
        } else if (topNode.actVal < this.min) {
            // new Minimum since 2*val -preMin = new value;
            // new_min = 2*current_min - new_value(this.top)
            this.min = 2 * this.min - topNode.actVal;
            this.top = topNode.next;
            return topNode.actVal;
        } else {
            this.top = topNode.next;
            return topNode.actVal;
        }
    }


    /*
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [null,null,null,null,-3,null,-2,-2]
     */
    public static void main(String[] args) {
        MinStackUsingMaths minStack = new MinStackUsingMaths();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("-----print stack------");
        printStack(minStack);
        System.out.println("current minVal is : { " + minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("-----print stack------");
        printStack(minStack);
        System.out.println("top element :- "+ minStack.top());    // return 0
        System.out.println("current min:- "+ minStack.getMin());
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

    private static void printStack(MinStackUsingMaths minStackUsingPair) {
        MinStackUsingMaths.Node top = minStackUsingPair.top;
        while (top != null) {
            System.out.println("actVal : { " + top.actVal);
            top = top.next;
        }
    }
}
