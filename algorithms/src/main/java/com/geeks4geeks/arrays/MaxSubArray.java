package com.geeks4geeks.arrays;

import java.util.Scanner;

/**
 * Created by ksharma on 8/30/15.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();

        int max1=0, max2=0;

        if( tests >= 1 && tests <= 10){
            do{
                int num = scan.nextInt();
                if( num >= 1 && num <= Math.pow(10,5)){
                    int arr[] = new int[num];
                    int i=0;
                    do{
                        int val = scan.nextInt();
                        if(val >= (-1)*Math.pow(10,4) && val <= Math.pow(10,4)){
                            arr[i] = val;
                            if(val >= 0){
                                max2 = max2 + val;
                            }
                        }
                        i++;
                        num--;
                    }while(num>0);
                    max1 = arr[0];
                    int sum[] = new int[arr.length];
                    sum[0] = arr[0];
                    for(int m=1; m< arr.length; m++){
                        sum[m] = Math.max(arr[m], sum[m - 1] + arr[m]);
                        max1 = Math.max(max1, sum[m]);
                    }
                    if(max2 ==0){
                        max2= max1;
                    }
                }
                System.out.println(max1 + " " + max2);
                max1=0; max2=0;
                tests--;
            }while(tests>0);
        }
    }
}
