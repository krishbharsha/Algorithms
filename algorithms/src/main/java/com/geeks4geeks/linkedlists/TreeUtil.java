package com.geeks4geeks.linkedlists;


import java.util.*;

class TreeIterator {
    Stack<Node> stack = null;

    TreeIterator(Node node) {
        stack = new Stack<Node>();

        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public int next() {
        Node node = stack.pop();
        int result = node.data;

        if (node.right != null) {
            //one node towards right add in stack
            node = node.right;
            while (node != null) {
                stack.push(node);
                //then add all nodes to left in stack
                node = node.left;
            }
        }

        return result;
    }
}

class Node {
    int data;
    Node left,right;

    Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}


public class TreeUtil {

    public static void printTreeLevel(Node root) {
        // Node node=root;
        int currentLevelCt = 0;
        int nextLevelCt = 0;
        if (root == null)
            return;
        else {
            Queue<Node> nodeQueue = new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            nodeQueue.add(root);
            currentLevelCt++;
            while (!nodeQueue.isEmpty()) {
                Node node = nodeQueue.remove();
                currentLevelCt--;
                System.out.print(node.data + " ");

                if (node.left != null) {
                    nodeQueue.add(node.left);
                    nextLevelCt++;
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    nextLevelCt++;
                }
                if (currentLevelCt == 0) {
                    currentLevelCt = nextLevelCt;
                    nextLevelCt = 0;
                    System.out.println();
                }
            }
        }

    }

    public static boolean isSameTree(Node root1, Node root2) {
        if ((root1 == null) && (root2 == null))
            return true;
        if ((root1 == null) || (root2 == null))
            return false;
        if (root1.data == root2.data)
            return (isSameTree(root1.left, root2.left) && isSameTree(
                    root1.right, root2.right));
        else
            return false;
    }

    public static boolean isBST(Node node, int min, int max) {
        if (node == null)
            return true;
        if ((node.data < min) || (node.data > max))
            return false;
        return (isBST(node.left, min, node.data) && isBST(node.right,
                node.data, max));

    }

    public static int preOrderCount = 0;

    public static Node constructTreeFromInPre(int[] in, int[] pre, int st,
                                              int end) {
        if (in.length == 0 || pre.length == 0)
            return null;
        if (st > end)
            return null;
        Node root = new Node(pre[preOrderCount++]);
        if (st == end)
            return root;
        int pos = Arrays.binarySearch(in, root.data);

        root.left = constructTreeFromInPre(in, pre, st, pos - 1);
        root.right = constructTreeFromInPre(in, pre, pos + 1, end);
        return root;

    }

    public static void serialize(Node root, Queue<Integer> dataQueue) {
        if (root == null) {
            dataQueue.add(-1);
            return;
        }
        dataQueue.add(root.data);
        serialize(root.left, dataQueue);
        serialize(root.right, dataQueue);
        return;
    }

    public static Node deserialize(Queue<Integer> dataQueue) {
        if (dataQueue.isEmpty())
            return null;
        if (dataQueue.peek() == -1) {
            dataQueue.remove();
            return null;
        }
        Node root = new Node(dataQueue.remove());
        root.left = deserialize(dataQueue);
        root.right = deserialize(dataQueue);
        return root;
    }

    public static void printPaths(Node root, int[] arr, int index) {
        if (root == null)
            return;
        arr[index++] = root.data;
        printPaths(root.left, arr, index);
        printPaths(root.right, arr, index);
        if (root.left == null && root.right == null) {
            for (int i = 0; i < index; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static int sumOfSiblings(Node root) {
        int sum = 0;
        if (root == null)
            return 0;
        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;
        return (sumOfSiblings(root.left) + sumOfSiblings(root.right) + sum);
    }

    public static Node mirrorTree(Node root) {
        if (root == null)
            return null;
        Node temp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);

        root.right = temp;
        return root;
    }

    public static Node trimTree(Node root, int st, int end) {
        if (root == null)
            return null;
        root.left = trimTree(root.left, st, end);
        root.right = trimTree(root.right, st, end);
        if (st <= root.data && root.data <= end)
            return root;
        else if (root.data < st)
            return root.right;
        else
            return root.left;

    }

    public static int treeSize(Node root) {
        if (root == null)
            return 0;
        else
            return (treeSize(root.left) + treeSize(root.right) + 1);
    }

    public static int getKthSmallest(Node root, int k) {
        if (root == null)
            return 0;

        if (treeSize(root.left) == k - 1)
            return root.data;

        if (treeSize(root.left) > k - 1)
            return (getKthSmallest(root.left, k));
        else
            return (getKthSmallest(root.right, k - (treeSize(root.left) + 1)));

    }

    public static Node doubleTree(Node node) {
        if (node == null)
            return null;

        Node newNode = new Node(node.data);
        Node temp = doubleTree(node.left);
        node.left = newNode;
        newNode.left = temp;
        node.right = doubleTree(node.right);
        return node;
    }

    public static int depthTree(Node node) {
        if (node == null) return 0;

        return (max(depthTree(node.left), depthTree(node.right)) + 1);
    }

    public static int depthTreeWithoutRec(Node node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null)
            return 1;

        Queue<Node> queue = new LinkedList<Node>();
        Queue<Node> testQ = new PriorityQueue<>();
        int currentNode = 0;
        int nextNode = 0;
        int height = 0;
        queue.add(node);
        currentNode++;

        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            currentNode--;

            if (node1.left != null) {
                queue.add(node1.left);
                nextNode++;
            }

            if (node1.right != null) {
                queue.add(node1.right);
                nextNode++;
            }

            if (currentNode == 0) {
                currentNode = nextNode;
                nextNode = 0;
                height++;
            }
        }

        return height;


    }

    public static int max(int x1, int x2) {
        return (x1 >= x2) ? x1 : x2;
    }

    public static Node lowestCommonAncestor(Node node, int a, int b) {
        if (node == null) return null;

        if (node.left == null && node.right == null) return node;

        if (node.data > a && node.data > b)
            return lowestCommonAncestor(node.left, a, b);
        if (node.data < a && node.data < b)
            return lowestCommonAncestor(node.right, a, b);

        return node;

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // Binary tree data set
        int[] dataArr = {7, 5, 10, 2, 6};
        Node root1 = tree.createTree(dataArr);

        int[] dataArr1 = {7, 5, 10, 2, 6, 8};
        Node root2 = tree.createTree(dataArr1);

        int[] dataArr2 = {7, 7, 5, 10, 6};
        Node root3 = tree.createTree(dataArr2);

        // printTreeLevel(root2);
        // System.out.println("This tree is BST: "+isBST(root3,Integer.MIN_VALUE,Integer.MAX_VALUE));

        // System.out.println("Are same trees: "+isSameTree(root1,root2));
        int[] in = {2, 5, 6, 7, 8, 10};
        int[] pre = {7, 5, 2, 6, 10, 8};
        // Node root4=constructTreeFromInPre(in,pre,0,in.length-1);

        // Queue<Integer> dataQueue = new LinkedList<Integer>();
        // serialize(root2,dataQueue);
        // Node root5=deserialize(dataQueue);

        // int[] arr = new int[10];
        // printPaths(root1,arr,0);

        // System.out.println("Sum of siblings: "+sumOfSiblings(root3));

        // Node root6=mirrorTree(root2);

        // Node root7=trimTree(root2,6,10);
        // printTreeLevel(root7);

        // System.out.println("Element is: " + getKthSmallest(root1, 5));
        //Node root8 = doubleTree(root2);
        //printTreeLevel(root8);
        //System.out.println(depthTree(root1));
        //System.out.println(depthTreeWithoutRec(root1));
        //System.out.println(lowestCommonAncestor(root1,3,4));
        TreeIterator it = new TreeIterator(root1);
        while (it.hasNext())
            System.out.println(it.next());
    }


}

