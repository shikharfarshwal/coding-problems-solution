package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversalRecursively {

    private final List<Integer> inOrderList = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(6);
        node.right.left = new TreeNode(5);
        node.right.left.left = new TreeNode(7);
        InOrderTraversalRecursively inOrderTraversalRecursively = new InOrderTraversalRecursively();
        System.out.println(inOrderTraversalRecursively.inorderTraversal(node));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return inOrderList;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
