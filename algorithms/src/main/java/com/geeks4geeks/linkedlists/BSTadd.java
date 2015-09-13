package com.geeks4geeks.linkedlists;

/**
 * Created by ksharma on 8/24/15.
 */
public class BSTadd {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node Insert(Node root, int value) {

        if (root == null) {
            root = new Node();
            root.data = value;
        }

        if (value < root.data) {
            if (root.left != null)
                root.left = Insert(root.left, value);
            else if (root.left == null) {
                root.left = new Node();
                root.left.data = value;
            }
        } else if (value > root.data) {
            if (root.right != null) {
                root.right = Insert(root.right, value);
            } else if (root.right == null) {
                root.right = new Node();
                root.right.data = value;
            }
        }

        return root;

    }

    static Node lca(Node root,int v1,int v2)
    {

        if(root == null){
            return null;
        }

        Node temp = new Node();

        if( v1 < root.data && v2 < root.data){
            temp = lca(root.left, v1, v2);
        } else if (v1 > root.data && v2 > root.data){
            temp = lca(root.right, v1, v2);
        } else if ((v1 < root.data && v2 > root.data) || (v2 < root.data && v1 > root.data)){
            return root;
        } else if (v1 == root.data || v2 == root.data){
            return root;
        }

        return temp;

    }


}
