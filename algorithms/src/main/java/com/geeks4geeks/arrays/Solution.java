package com.geeks4geeks.arrays;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

//        Scanner scan = new Scanner(System.in);
//        int val = scan.nextInt();
//        StringBuilder sb = new StringBuilder();
//
//        for(int m=0; m<val;m++){
//            sb.append(" ");
//        }
//
//        if(val >=1 && val <=100){
//            int count = val;
//            do {
//                sb.insert((val - 1), "#");
//                //System.out.println(sb.toString());
//
//                for(int m=0; m< count;m++){
//                    System.out.print(sb.charAt(m));
//                }
//                System.out.println();
//                val--;
//            }while(val > 0);
//        }

        int[][] intArray = new int[10][20];

        System.out.println(intArray.length);

        System.out.println(intArray[0].length);

        int a = 10, b = 20;
        int dub = Math.min(a,b);
        int ab = dub;

    }
}
