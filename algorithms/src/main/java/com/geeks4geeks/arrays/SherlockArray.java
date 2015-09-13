package com.geeks4geeks.arrays;

import java.util.Scanner;

/**
 * Created by ksharma on 9/3/15.
 */
public class SherlockArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();

        if (tests > 0 && tests <= 10) {
            while (tests > 0) {
                int num = scan.nextInt();
                if (num > 0 && num <= Math.pow(10, 5)) {
                    int[] intArr = new int[num];
                    int sum = 0;
                    int revSum = 0;
                    if (num == 1) {
                        System.out.println("NO");
                        tests--; continue;
                    }
                    for (int m = 0; m < num; m++) {
                        int temp = scan.nextInt();
                        if (temp > 0 && temp <= Math.pow(10, 4)) {
                            intArr[m] = temp;
                            sum = sum + intArr[m];
                        }
                    }
                    for (int n = num - 1; n > 0; n--) {
                        revSum = revSum + intArr[n];
                        int temp = sum - (intArr[n - 1] + revSum);
                        if (temp == revSum) {
                            System.out.println("YES");
                            break;
                        }
                        if (n == 1) {
                            System.out.println("NO");
                        }
                    }
                }
                tests--;
            }
        }
    }
}
