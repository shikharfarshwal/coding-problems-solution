package com.example;

public class B {


    public void X(String s) {
        System.out.println("in stvring");
    }


    public void X(Object o) {
        System.out.println("in object");
    }

    public void X(Integer o) {
        System.out.println("in integer");
    }


    public static void main(String[] args) {
        B b = new B();
    }
}
