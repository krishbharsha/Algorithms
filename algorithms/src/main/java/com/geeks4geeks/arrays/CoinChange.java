package com.geeks4geeks.arrays;

import java.util.*;

/**
 * Created by ksharma on 8/30/15.
 */
public class CoinChange {

    public static void main(String[] args) throws Exception {

        long count = 0;

        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();

        if (total >= 1 && total <= 250) {
            int coins = scan.nextInt();
            if (coins >= 1 && coins <= 250) {
                int arr[] = new int[coins];
                for (int m = 0; m < coins; m++) {
                    int newCoin = scan.nextInt();
                    if (newCoin >= 1 && newCoin <= 50) {
                        arr[m] = newCoin;
                    }
                }
                count = findTotalWays(arr, total);

            }
        }

        System.out.println(count);

    }

    public static long findTotalWays(int[] arr, int total) {

        long temp[][] = new long[arr.length+1][total+1];

        for(int i=0; i <= arr.length; i++){
            temp[i][0] = 1;
        }

        for(int i=1; i <= arr.length; i++){
            for(int j=1; j <= total ; j++){
                if(arr[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-arr[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[arr.length][total];
    }

    /**
     * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
     * can be very low negative number
     */
    public int minCoinChangeInfinteSupply(int total, int arr[]){
        int temp[] = new int[total+1];
        temp[0] = 0;
        for(int i=1; i <= total; i++){
            temp[i] = Integer.MAX_VALUE-1;
        }
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total; j++){
                if(j >= arr[i]){
                    //be careful here. Max_val + 1 can result in very small negative number.
                    temp[j] = Math.min(temp[j], temp[j-arr[i]] +1);
                }
            }
        }
        return temp[total];
    }
}
