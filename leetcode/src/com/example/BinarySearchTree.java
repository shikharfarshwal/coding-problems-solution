package com.example;

import java.util.*;

public class BinarySearchTree {

    Stack<Node> stack = new Stack();
    /**
     * 9
     * 4           20
     * 1       6   15      170
     */
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        final BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(120);
        binarySearchTree.insert(70);
        binarySearchTree.insert(4);
        binarySearchTree.insert(null);
        binarySearchTree.insert(null);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
       // System.out.println(binarySearchTree);
        //System.out.println(binarySearchTree.lookUp(15));
        //binarySearchTree.remove(20);
        //System.out.println(binarySearchTree);
        //System.out.println(binarySearchTree.breadthFirstSearch());
        System.out.println("inOrder " + binarySearchTree.depthFirstSearchInOrder(binarySearchTree.root, new ArrayList<>()));
        System.out.println("preOrder " + binarySearchTree.depthFirstSearchPreOrder(binarySearchTree.root, new ArrayList<>()));
        System.out.println("postOrder " + binarySearchTree.depthFirstSearchPostOrder(binarySearchTree.root, new ArrayList<>()));
       System.out.println(binarySearchTree.isValidBSTUsingInOrder(binarySearchTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(binarySearchTree.maxDepth(binarySearchTree.root));
        Integer[] integers = Arrays.asList(-10, -3, 0, 5, 9).stream().toArray(Integer[]::new);
        binarySearchTree.sortedArrayToBST(integers);
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    public void insert(final Integer value) {
        if (value != null) {
            Node newNode = new Node(value);
            if (this.root == null) {
                this.root = newNode;
            } else {
                Node currentNode = this.root;
                while (true) {
                    if (value < currentNode.value) {
                        if (currentNode.left == null) {
                            currentNode.left = newNode;
                            return;
                        }
                        currentNode = currentNode.left;
                    } else {
                        if (currentNode.right == null) {
                            currentNode.right = newNode;
                            return;
                        }
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public Integer lookUp(final Integer value) {
        Node currentNode = this.root;
        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return currentNode.value;
            }
        }
        return null;
    }

    private void remove(final Integer value) {
        Node currentNode = this.root;
        Node previousNode = currentNode;
        while (currentNode != null) {
            if (value < currentNode.value) {
                previousNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                previousNode = currentNode;
                currentNode = currentNode.right;
            } else if (currentNode.value == value) {
                //we have a match
                //option 1: right child
                if (currentNode.right == null) {
                    if (previousNode == null) {
                        this.root = currentNode.left;
                    } else {
                        //if parent > current value, make current left child a child of parent
                        if (currentNode.value < previousNode.value) {
                            previousNode.left = currentNode.left;
                            //if parent < current value, make left child a right child of parent
                        } else if (currentNode.value > previousNode.value) {
                            previousNode.right = currentNode.left;
                        }
                    }//Option 2: Right child which doesnt have a left child
                } else if (currentNode.right.left == null) {
                    currentNode.right.left = currentNode.left;
                    if (previousNode == null) {
                        this.root = currentNode.right;
                    } else {
                        //if parent > current, make right child of the left the parent
                        if (currentNode.value < previousNode.value) {
                            previousNode.left = currentNode.right;
                            //if parent < current, make right child a right child of the parent
                        } else if (currentNode.value > previousNode.value) {
                            previousNode.right = currentNode.right;
                        }
                    }
                    //Option 3: Right child that has a left child
                } else {
                    if (currentNode.right.left != null) {
                        Node successorNode = currentNode.right;
                        while (true) {
                            if (successorNode.left != null) {
                                successorNode = successorNode.left;
                            } else {
                                break;
                            }
                        }
                        if (currentNode.value.equals(previousNode.left.value)) {
                            previousNode.left = successorNode;
                            successorNode.left = currentNode.left;
                            successorNode.right = currentNode.right;
                            currentNode = null;
                        } else {
                            previousNode.right = successorNode;
                            successorNode.left = currentNode.left;
                            successorNode.right = currentNode.right;
                            currentNode = null;
                        }
                    } else if (currentNode.value.equals(previousNode.left.value)) {
                        previousNode.left = null;
                        currentNode = null;
                    } else {
                        previousNode.right = null;
                        currentNode = null;
                    }
                }
            }
        }
    }

    private List<Node> breadthFirstSearch() {
        Node currentNode = this.root;
        List<Node> traversed = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            System.out.println(currentNode.value);
            traversed.add(currentNode);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return traversed;
    }

    private List<Integer> depthFirstSearchInOrder(final Node root, final List<Integer> traveresed) {
        return traverseTreeInOrder(root, traveresed);
    }

    private List<Integer> depthFirstSearchPreOrder(final Node root, final List<Integer> traveresed) {
        return traverseTreePreOrder(root, traveresed);
    }

    private List<Integer> depthFirstSearchPostOrder(final Node root, final List<Integer> traveresed) {
        return traverseTreePostOrder(root, traveresed);
    }

    //L|ROOT|R
    private List<Integer> traverseTreeInOrder(Node root, List<Integer> traveresed) {
        Node currentNode = root;
        System.out.println("visited " + currentNode.value);
        if (currentNode.left != null) {
            traverseTreeInOrder(currentNode.left, traveresed);
        }
        traveresed.add(currentNode.value);
        if (currentNode.right != null) {
            traverseTreeInOrder(currentNode.right, traveresed);
        }
        return traveresed;
    }

    //ROOT|L|R
    private List<Integer> traverseTreePreOrder(Node root, List<Integer> traveresed) {
        Node currentNode = root;
        System.out.println("visited " + currentNode.value);
        traveresed.add(currentNode.value);
        if (currentNode.left != null) {
            traverseTreePreOrder(currentNode.left, traveresed);
        }
        if (currentNode.right != null) {
            traverseTreePreOrder(currentNode.right, traveresed);
        }
        return traveresed;
    }

    //L|R|ROOT
    private List<Integer> traverseTreePostOrder(Node root, List<Integer> traveresed) {
        Node currentNode = root;
        System.out.println("visited " + currentNode.value);
        if (currentNode.left != null) {
            traverseTreePostOrder(currentNode.left, traveresed);
        }
        if (currentNode.right != null) {
            traverseTreePostOrder(currentNode.right, traveresed);
        }
        traveresed.add(currentNode.value);
        return traveresed;
    }

    /**
     * Not working for following case [0,-1]
     *
     * @param root
     * @return
     */
    public boolean isValidBST(Node root) {
        Node currentNode = root;
        final Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            if (currentNode.left != null) {
                if (currentNode.left.value < currentNode.value) {
                    queue.add(currentNode.left);
                } else {
                    return false;
                }
            } else if (currentNode.right != null) {
                return false;
            }
            if (currentNode.right != null) {
                if (currentNode.right.value > currentNode.value) {
                    queue.add(currentNode.right);
                } else {
                    return false;
                }
            } else if (currentNode.left != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBSTUsingInOrder(Node root, Integer min, Integer max) {
        if (root == null)
            return true;
        boolean left = false, right = false;

        if (root.left == null || (root.left.value < root.value && root.left.value > min)) {
            left = true;
        }


        if (root.right == null || (root.right.value > root.value && root.right.value < max)) {
            right = true;
        }

        if (left && right) {
            return isValidBSTUsingInOrder(root.left, Integer.MIN_VALUE, root.value) &&
                    isValidBSTUsingInOrder(root.right, root.value, Integer.MAX_VALUE);
        } else {
            return false;
        }
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        Node current = root;
        int leftCount = 0;
        int rightCount = 0;
        if (current.left != null) {
            leftCount = maxDepth(current.left);
        }
        if (current.right != null) {
            rightCount = maxDepth(current.right);
        }
        return leftCount > rightCount ? leftCount + 1 : rightCount + 1;
    }


    //height balance BST code


    public Node sortedArrayToBST(Integer[] nums) {
        root = null;
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            insertNodeHeightBalnaced(node);
        }

        System.out.println(root);
        return root;
    }


    private void insertNodeHeightBalnaced(Node node) {
        if (root == null) {
            root = node;
        } else {
            Node currentNode = this.root;
            while (true) {
                if (currentNode.value > node.value) {
                    if (currentNode.left == null) {
                        currentNode.left = node;
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = node;
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    private class Node {
        private Node left;
        private Node right;
        private Integer value;

        private Node(final Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }

}
