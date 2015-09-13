package com.geeks4geeks.arrays;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ksharma on 7/11/15.
 * Binary search on a sorted array.
 */
public class BinarySearch {

    private static int[] intArray;

    private static int abc;

    public static void main(String args[]) {

        intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int[]a[] = new int[5][5];
        int[] dayhigh = { 24, 23, 24, 25, 25, 23, 21 };


        //binarySearch(1);

        System.out.println(abc);

        char[] c = new char[100];

        System.out.println(c[50]);

        String[] d = new String[20];

        System.out.println(d[10]);

        String s = "Hello" +
                "Java";

        System.out.println(s);

        String s1 = "Hello";
        String s2= "Java";
        s1.concat( s2 );

        System.out.println(s1.concat( s2 ));

        String s3 = new String( "Computer" );

        if( s3 == "Computer" )
            System.out.println( "Equal A" );
        if( s3.equals( "Computer" ) )
            System.out.println( "Equal B" );

        double test = -4.4;

        int testval = (int) Math.round(test);

        char ch = '\u0000';

        System.out.println(ch);

        System.out.println(testval);

        Queue<Integer> queue = new LinkedList();

        queue.offer(1);
    }

    private static void binarySearch(int val) {

        int len = intArray.length;
        boolean flag = false;

        if (len == 0) {
            System.out.println("array size 0. What do u expect ?");
        } else {
            int low = 0;
            int high = len - 1;

            while( low <= high) {
                int middle = (low+high)/2;
                if(val > intArray[middle]){
                    low = middle+ 1;
                } else if (val < intArray[middle]){
                    high = middle -1;
                } else {
                    System.out.print("element found");
                    flag = true;
                    break;
                }
            }

            if(!flag) System.out.print("element not found");

        }

    }
}
