package com.geeks4geeks.arrays;

import java.util.*;

public class StockMax {

    public static void main(String[] args) throws Exception {

        long count = 0;

        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();

        if (tests >= 1 && tests <= 10) {
            do {
                int input = scan.nextInt();
                if (input >= 1 && input <= 50000) {
                    long arr[] = new long[input];
                    for (int m = 0; m < input; m++) {
                        int stockPrice = scan.nextInt();
                        if (stockPrice >= 1 && stockPrice <= 100000) {
                            arr[m] = stockPrice;
                        }
                    }
                    count = stockMax(arr);
                    System.out.println(count);
                }
                tests--;
            } while (tests > 0);
        }

    }

    public static long stockMax(long[] arr) {

        int len = arr.length;
        long buy = 0; //5
        long sell = 0; //0
        long count = 0;

        for (int m = 0; m < len -1; m++) {
            if (arr[m] < arr[m + 1]) {
                buy = buy + arr[m];
                count++;
            } else if (arr[m] >= arr[m + 1]) {
                sell = sell + (arr[m]*count - buy);
                buy = 0;
                count = 0;
            }
            if (m + 1 == len - 1) {
                sell = sell + (arr[m+1]*count - buy);
            }
        }

        return sell;
    }
}
