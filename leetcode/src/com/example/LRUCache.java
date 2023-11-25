package com.example;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Node head, tail;
    private int capacity, count;
    private Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0);
        tail = new Node(0);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache);
        System.out.println("item in cache is " + cache.get(1));
        cache.set(3, 3);
        System.out.println("item in cache is " + cache.get(2));
        cache.set(2, 2);
        System.out.println(cache);

    }


    private void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                System.out.println("capacity is at max removing LRU node [" + tail.prev.value + " ]");
                map.remove(tail.prev.value);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }

    private int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int value = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got value [" + value + "] for key [" + key + " ]");
            return value;
        }
        return -1;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }

}
