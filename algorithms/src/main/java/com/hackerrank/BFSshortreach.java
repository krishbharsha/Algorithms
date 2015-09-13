package com.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ksharma on 7/29/15.
 */
public class BFSshortreach {

    static class Vertex {

        private HashMap<Integer, Integer> vertexMap = new HashMap<>();

        public void addVertex(int label) {
            vertexMap.put(label, 0);
        }

        public HashMap<Integer, Integer> getVertexMap() {
            return vertexMap;
        }
    }

    static class Queue {
        private int size;
        private int[] intArray;
        private int front;
        private int rear;

        public Queue(int size) {
            this.size = size;
            intArray = new int[size];
            front = 0;
            rear = -1;
        }

        public void enQueue(int elem) {
            if (rear == size - 1)
                rear = -1;
            intArray[++rear] = elem;

        }

        public int deQueue() {
            int temp = intArray[front++];
            if (front == size) front = 0;
            return temp;
        }

        public boolean isEmpty() {
            return (front + size - 1 == rear || rear + 1 == front);
        }

    }

    static class Graph {
        private int maxVerts;
        private Vertex vertex;
        private int adjMat[][];
        private int nVerts;
        private Queue queue;
        private int edgeVal;

        public Graph(int maxVerts, int edgeVal) {
            this.maxVerts = maxVerts;
            nVerts = 0;
            queue = new Queue(maxVerts);
            vertex = new Vertex();
            adjMat = new int[maxVerts][maxVerts];
            this.edgeVal = edgeVal;
            for (int m = 0; m < maxVerts; m++) {
                for (int n = 0; n < maxVerts; n++) {
                    adjMat[m][n] = 0;
                }
            }
        }

        public void addVertex(int label) {

            vertex.addVertex(label);
        }

        public HashMap<Integer, Integer> getVertexMap() {

            return vertex.getVertexMap();
        }

        public void addEdge(int start, int end) {

            adjMat[start][end] = edgeVal;
            adjMat[end][start] = edgeVal;
        }

        public void bfsShortReach(int node) {

            HashMap<Integer, Integer> tempVertexMap = getVertexMap();

            int vertVal, val = 6;

            vertVal = tempVertexMap.get(node - 1);
            tempVertexMap.put(node - 1, ++vertVal);

            for (int m = 0; m < maxVerts; m++) {
                if (adjMat[node - 1][m] == 6) {
                    System.out.print(val + " ");
                    queue.enQueue(m);
                    vertVal = tempVertexMap.get(m);
                    tempVertexMap.put(m, ++vertVal);
                } else if (m != node - 1) {
                    System.out.print("-1 ");
                }
            }

            while (!queue.isEmpty()) {
                val = val + 6;
                node = queue.deQueue();
                for (int m = 0; m < maxVerts; m++) {
                    if (adjMat[node][m] == 6) {
                        vertVal = tempVertexMap.get(m);
                        if (vertVal == 0) {
                            System.out.print(val + " ");
                            queue.enQueue(m);
                            tempVertexMap.put(m, ++vertVal);
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        int numNodes, numEdges;

        if (testCases > 0 && testCases < 11) {
            while (testCases > 0) {
                numNodes = scan.nextInt();
                numEdges = scan.nextInt();

                Graph graph = new Graph(numNodes, 6);
                if (numEdges > 0 && numEdges <= (numNodes * (numNodes - 1)) / 2) {
                    while (numEdges > 0) {
                        int vertex1 = scan.nextInt();
                        graph.addVertex((vertex1 - 1));
                        int vertex2 = scan.nextInt();
                        graph.addVertex((vertex2 - 1));
                        graph.addEdge(vertex1 - 1, vertex2 - 1);
                        numEdges--;
                    }
                } else break;

                graph.bfsShortReach(scan.nextInt());
                System.out.println();
                testCases--;
            }
        }
    }
}













