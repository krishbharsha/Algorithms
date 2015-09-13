package com.geeks4geeks.arrays;

/**
 * Created by ksharma on 7/11/15.
 * Given an array of positive integers.
 * All numbers occur even number of times
 * except one number which occurs odd number of times.
 */
public class OddNumNumber {

    private static int[] intArray;

    public static void main(String args[]) {

        intArray = new int[]{1, 2, 3, 2, 3, 1, 3};

        isNumNumber();

    }

    private static void isNumNumber() {

        int value = 0;

        for (int m = 0; m < intArray.length; m++) {
            value = value ^ intArray[m];
        }
        System.out.print(value);
    }

}
