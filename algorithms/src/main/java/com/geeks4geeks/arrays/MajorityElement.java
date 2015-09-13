package com.geeks4geeks.arrays;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ksharma on 7/11/15.
 * A majority element in an array A[] of size n is an element
 * that appears more than n/2 times (and hence there is
 * at most one such element).
 */
public class MajorityElement {

    private static int[] intArray;

    public static void main(String args[]) {

        //intArray = new int[]{3, 3, 4, 2, 4, 4, 2, 4};
        intArray = new int[]{ 2, 2, 3, 5, 2, 2,3, 6};

        isMajor();

    }

    private static void isMajor() {

        int len = intArray.length;
        boolean flag = false;

        HashMap<Integer, Integer> arraySet = new HashMap();

        for (int m = 0; m < len; m++) {
            int val = 0;
            if (arraySet.containsKey(intArray[m])) {
                val = arraySet.get(intArray[m]);
            }
            arraySet.put(intArray[m], ++val);
            if (val > len / 2) {
                System.out.println(intArray[m]);
                flag = true;
                break;
            }
        }

        if(!flag)System.out.println("NONE");


    }
}
