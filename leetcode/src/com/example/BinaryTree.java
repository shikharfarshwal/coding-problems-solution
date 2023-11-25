package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    //RLR
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            final TreeNode pop = stack.pop();
            preOrder.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return preOrder;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        final Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.empty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            inOrder.add(current.val);
            current = current.right;
        }
        return inOrder;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
