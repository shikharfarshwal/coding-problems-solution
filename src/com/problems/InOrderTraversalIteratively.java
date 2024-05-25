package com.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIteratively {

    private final List<Integer> inOrderList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(6);
        node.right.left = new TreeNode(5);
        node.right.left.left = new TreeNode(7);
        InOrderTraversalIteratively inOrderTraversalIteratively = new InOrderTraversalIteratively();
        System.out.println(inOrderTraversalIteratively.inorderTraversal(node));
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return inOrderList;
    }


    private void inOrder(TreeNode node){
        final Stack<TreeNode> stack = new Stack();
        TreeNode curr = node;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr= curr.left;
            }else{
                curr=stack.pop();
                inOrderList.add(curr.val);
                curr=curr.right;
            }
        }
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


