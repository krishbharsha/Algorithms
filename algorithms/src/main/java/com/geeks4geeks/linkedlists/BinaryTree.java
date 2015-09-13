package com.geeks4geeks.linkedlists;


import java.util.ArrayList;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void setRoot(Node node) {
        root = node;
    }

    public Node insert(Node node, int data) {
        if (node == null)
            node = new Node(data);
        else {
            if (node.data > data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public Node createTree(int[] arrData) {
        Node node = null;
        for (int x : arrData) {
            node = insert(node, x);
        }
        return node;
    }

    public void printPreOrder(Node root, ArrayList<Integer> nodeList) {
        Node node = root;
        if (node == null)
            return;
        else {
            // System.out.print(node.data+" ");
            nodeList.add(node.data);
            printPreOrder(node.left, nodeList);
            printPreOrder(node.right, nodeList);
        }

    }

    public void printInOrder(Node root, ArrayList<Integer> nodeList) {
        Node node = root;
        if (node == null)
            return;
        else {
            printInOrder(node.left, nodeList);
            nodeList.add(node.data);
            printInOrder(node.right, nodeList);
        }
    }

    public void printPostOrder(Node root, ArrayList<Integer> nodeList) {
        Node node = root;
        if (node == null)
            return;
        else {
            printPostOrder(node.left, nodeList);
            printPostOrder(node.right, nodeList);
            nodeList.add(node.data);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] treeList = { 7, 5, 10, 2, 6 };
        Node node = tree.createTree(treeList);

        ArrayList<Integer> preOrderList = new ArrayList<Integer>();
        tree.printPreOrder(node, preOrderList);
        System.out.print("PreOrder: " + preOrderList + "\n");

        ArrayList<Integer> inOrderList = new ArrayList<Integer>();
        tree.printInOrder(node, inOrderList);
        System.out.print("Inorder: " + inOrderList + "\n");

        ArrayList<Integer> postOrderList = new ArrayList<Integer>();
        tree.printPostOrder(node, postOrderList);
        System.out.println("PostOrder: " + postOrderList + "\n");
    }
}
