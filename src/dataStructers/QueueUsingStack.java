package dataStructers;

import java.util.Stack;

/**
 * Created by Shikhar on 16-02-2019.
 */
public class QueueUsingStack {

    private Stack<String> stack;
    private Stack<String> tempStack;

    @Override
    public String toString() {
        return "dataStructers.QueueUsingStack{" +
                "stack=" + stack +
                ", tempStack=" + tempStack +
                '}';
    }

    public QueueUsingStack() {
        this.stack = new Stack<>();
        this.tempStack = new Stack<>();
    }


    private Object pop() {
        return this.stack.pop();
    }

    private void push(String value) {
        Stack<String> stack = this.stack;
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
            this.stack.push(value);
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }
    }

    private Object peek() {
        if (this.stack.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return this.stack.peek();
        }
    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.push("1");
        queueUsingStack.push("2");
        queueUsingStack.push("3");
        queueUsingStack.push("4");
        System.out.println(queueUsingStack);
        System.out.println("Popped element is " + queueUsingStack.pop());
        System.out.println(queueUsingStack);
        System.out.println("1 element in queue is:- " + queueUsingStack.peek());
        System.out.println("Popped element is " + queueUsingStack.pop());
        System.out.println(queueUsingStack);
        System.out.println("1 element in queue is:- " + queueUsingStack.peek());
        System.out.println("Popped element is " + queueUsingStack.pop());
        System.out.println(queueUsingStack);
        System.out.println("1 element in queue is:- " + queueUsingStack.peek());
        System.out.println(queueUsingStack);
    }
}
