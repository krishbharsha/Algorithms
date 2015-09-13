package com.geeks4geeks.arrays;

import java.util.*;


/**
 * Created by ksharma on 8/29/15.
 */
public class SumBytwo implements Cloneable{

        public static void main(String []args){
            int[] arr = {1,2,3,6,7,8,9};

            Integer[] arr1 = {1,2};
            System.out.println(f(arr));

            SumBytwo sumBytwo = new SumBytwo();

            SumBytwo cloneSumByTwo;
            try {
                cloneSumByTwo = (SumBytwo) sumBytwo.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        public static List<List<Integer>> f(int[] arr){
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(arr);
            List<Integer> setA= new ArrayList<>();
            List<Integer> setB= new ArrayList<>();
            int countA=0, countB=0;
            list.add(setA);
            list.add(setB);
            int n = arr.length;
            int i=0;
            for(; i<(n/4)*2; i++){
                if(i%2 ==0){
                    setA.add(arr[i]);
                    setA.add(arr[n-(i+1)]);
                    countA+= arr[i] + arr[n-(i+1)];
                } else{
                    setB.add(arr[i]);
                    setB.add(arr[n-(i+1)]);
                    countB+= arr[i] + arr[n-(i+1)];
                }
            }

            int rem= n%4;

            if(rem==1){
                if(countA<countB){
                    setA.add(arr[i]);
                } else{
                    setB.add(arr[i]);
                }
                return list;
            }
            if(rem==2){
                if(countA<countB){
                    setB.add(arr[i]);
                    setA.add(arr[i+1]);
                } else{
                    setA.add(arr[i]);
                    setB.add(arr[i+1]);
                }
                return list;
            }
            if(rem==3){
                if(countA<countB){
                    setA.add(arr[i+2]);
                    countA+=arr[i+2];
                    if(countA<countB){
                        setB.add(arr[i]);
                        setA.add(arr[i+1]);
                    } else{
                        setA.add(arr[i]);
                        setB.add(arr[i+1]);
                    }
                } else{
                    setB.add(arr[i+2]);
                    countB+=arr[i+2];
                    if(countB<countA){
                        setA.add(arr[i]);
                        setB.add(arr[i+1]);
                    } else{
                        setB.add(arr[i]);
                        setA.add(arr[i+1]);
                    }
                }
                return list;
            }
            return list;
        }

    public SumBytwo clone() throws CloneNotSupportedException {

        return this;


        //return (SumBytwo) super.clone();


    }
}
