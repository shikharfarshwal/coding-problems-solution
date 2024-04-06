package com.old.code.dataStructers;

/**
 * Created by Shikhar on 17-02-2019.
 */
public class BinarySearchTree {
    private Node root;

    @Override
    public String toString() {
        return "dataStructers.BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    class Node {
        Node left;
        Node right;
        int value;

        @Override
        public String toString() {
            return "Node { value = " + value + " , " +
                    "left = " + left +
                    ", right = " + right +
                    '}';
        }

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Insert into a binary search tree.
     */
    private BinarySearchTree insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node currentNode = this.root;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left != null) {
                        currentNode = currentNode.left;
                    } else {
                        currentNode.left = newNode;
                        break;
                    }
                } else {
                    if (currentNode.right != null) {
                        currentNode = currentNode.right;
                    } else {
                        currentNode.right = newNode;
                        break;
                    }
                }
            }
        }
        return this;
    }
    /**
     * Search a value in BST.
     */
    private Node lookUp(int value) {
        int height = 0;
        if (this.root == null) {
            System.out.println("Empty Binary Tree");
            return null;
        } else {
            Node currentNode = this.root;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                    height++;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                    height++;
                } else if (value == currentNode.value) {
                    System.out.println("Value found at height{" + height + "}");
                    return currentNode;
                }
            }
        }
        System.out.println("No Node present for this value");
        return null;
    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println("LookUp is {" + binarySearchTree.lookUp(111) + "}");
        System.out.println("Insertion Starts");
        System.out.println(binarySearchTree.insert(9));
        System.out.println(binarySearchTree.insert(4));
        System.out.println(binarySearchTree.insert(6));
        System.out.println(binarySearchTree.insert(20));
        System.out.println(binarySearchTree.insert(170));
        System.out.println(binarySearchTree.insert(15));
        System.out.println(binarySearchTree.insert(1));
        System.out.println("LookUp is {" + binarySearchTree.lookUp(1) + "}");
        System.out.println("LookUp is {" + binarySearchTree.lookUp(111) + "}");
        System.out.println("LookUp is {" + binarySearchTree.lookUp(6) + "}");
        System.out.println("LookUp is {" + binarySearchTree.lookUp(20) + "}");
    }



}
