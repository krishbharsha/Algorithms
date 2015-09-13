package com.geeks4geeks.arrays;

/**
 * Created by ksharma on 8/29/15.
 */
public class Node implements Cloneable {
    private int value;
    private Node left;
    private Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node copy() {
        Node left = null;
        Node right = null;
        if (this.left != null) {
            left = this.left.copy();
        }
        if (this.right != null) {
            right = this.right.copy();
        }
        return new Node(value, left, right);
    }

    public Node clone() throws CloneNotSupportedException {

//        Node left = null;
//        Node right = null;
//        if (this.left != null) {
//            left = this.left.clone();
//        }
//        if (this.right != null) {
//            right = this.right.clone();
//        }
//        return new Node(value, left, right);

        return (Node) super.clone();
    }


    public static void main(String[] args) {

        Node nodeOne = new Node(20, null, null);

        Node nodeTwo = nodeOne.copy();

        Node nodeThree = null;

        try {
            nodeThree = nodeOne.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Before nodeOne : " + nodeOne.value);

        System.out.println("Before nodeTwo : " + nodeTwo.value);

        System.out.println("Before nodeTwo : " + nodeThree.value);

        nodeOne.value = 35;

        System.out.println("After nodeOne : " + nodeOne.value);

        System.out.println("After nodeTwo : " + nodeTwo.value);

        System.out.println("After nodeThree : " + nodeThree.value);

        StringBuilder sb = new StringBuilder();

        for(int m=0; m<= 100;m++){
            sb.append(" ");
        }

        sb.insert(100, "#");



    }

}
