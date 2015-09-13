package com.mylearnings.treesgraphs;

/**
 * Created by ksharma on 7/26/15.
 * Binary tree class and for coding exercises
 */
public class BinaryTree {

    private Node root;

    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            left = null;
            right = null;
            this.data = data;
        }
    }

    public BinaryTree() {
        root = null;
    }

    public boolean lookup(int data) {
        return lookup(root, data);
    }

    private boolean lookup(Node node, int data) {
        if (null == node) {
            return false;
        }

        if (data == node.data) {
            return true;
        } else if (data < node.data) {
            return lookup(node.left, data);
        } else {
            return lookup(node.right, data);
        }
    }

    public void insert(int data) {
        insert(root, data);
    }

    private Node insert(Node node, int data) {

        if (null == node) {
            node = new Node(data);
            return node;
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public void build123a() {
        root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
    }

    public void build123b() {

        root = null;
        root = insert(root, 2);
        root = insert(root, 1);
        root = insert(root, 3);
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (null == node) {
            return 0;
        } else
            return (size(node.left) + 1 + size(node.right));
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (null == node) {
            return 0;
        }
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);

        return Math.max(lDepth, rDepth) + 1;
    }

    public int minValue() {
        return minValue(root);
    }

    private int minValue(Node node) {
        Node current = node;
        while (null != current.left) {
            current = current.left;
        }
        return current.data;
    }

    public void printTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node node) {
        if (null == node) return;

        printTree(node.left);
        System.out.print(node.data + "  ");
        printTree(node.right);
    }

    public void printPostorder() {
        System.out.println("print post order");
        printPostorder(root);
        System.out.println();
    }

    public void printPostorder(Node node) {
        if (null == node) return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + "  ");

    }

    public boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    private boolean hasPathSum(Node node, int sum) {

        if (null == node) {
            return (sum == 0);
        }
        return (hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data));
    }

    public void mirror() {
        mirror(root);
    }

    private void mirror(Node node) {
        if (null != node) {
            mirror(node.left);
            mirror(node.right);

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    public void doubleTree() {
        doubleTree(root);
    }


    private void doubleTree(Node node) {
        if (null != node) {
            doubleTree(node.left);
            doubleTree(node.right);


            Node temp = node.left;
            node.left = new Node(node.data);
            node.left.left = temp;
        }
    }

    public boolean sameTree(BinaryTree other) {
        return (sameTree(root, other.root));
    }

    private boolean sameTree(Node a, Node b) {

        if (a == null && b == null) return true;
        else if (a != null || b != null) {
            return false;
        } else if (a != null && b != null) {
            return (
                    a.data == b.data &&
                            sameTree(a.left, b.left) &&
                            sameTree(a.right, b.right));
        } else return false;
    }


    public static void main(String args[]) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.build123a();
        binaryTree.size();
        binaryTree.printTree();
        binaryTree.printPostorder();
    }

}
































