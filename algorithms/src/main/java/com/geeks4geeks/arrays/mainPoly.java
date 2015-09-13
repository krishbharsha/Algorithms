package com.geeks4geeks.arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ksharma on 8/27/15.
 */
class testPoly {

    public int var = 10;

    public void printVar() {

        System.out.println("base class var : " + var);
    }
}

class testSubPoly extends testPoly {

    public int var = 30;

    public void printVar() {

        System.out.println("sub class var : " + var);
    }
}

public class mainPoly {

    public static void main(String args[]) throws IOException {

        testPoly testPolyObj = new testPoly();
        testPoly testPolySubObj = new testSubPoly();
        testSubPoly testSubPolyObj = new testSubPoly();

        System.out.println("is this poly base : " + testPolyObj.var);  //10
        System.out.println("is this poly base2sub: " + testPolySubObj.var);  //30
        System.out.println("is this poly sub: " + testSubPolyObj.var); //30


        testPolyObj.printVar();
        testPolySubObj.printVar();
        testSubPolyObj.printVar();

        BitSet bitSet = new BitSet();

        Map<Integer, String> map = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            map.get(entry.getKey());
            entry.getValue();
        }

        Collection a1 = new ArrayList();
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2;

        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        SortedSet<String> sortedSet = new TreeSet<>();

        String testing = "testing";

        testing.length();

        int[] intTest = new int[]{1, 2, 3};
        int len = intTest.length;


        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        Integer[] intArray = {1, 2, 3, 4, 5};

        printArray(intArray);

    }


    public static <E> void printArray(E[] inputArray) {
        // Display array elements
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();

        String test1 = "I am ";
        String test2 = "an idiot";

        test1.concat(test2);

        String test3 = test1 + test2;


    }


}