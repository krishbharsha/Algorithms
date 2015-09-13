package com.geeks4geeks.linkedlists;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by ksharma on 7/14/15.
 */
public class test {

    public static void main(String args[]){
        LinkedList dummy = new LinkedList();

        dummy.add(4);
        System.out.println(dummy.get(0));
        Object dum = dummy.get(0);
        System.out.println(dum);

        int a = new Integer(String.valueOf(dum));

        ArrayList<String> temp = new ArrayList<>();
        Vector<Integer> temp1 = new Vector<>();

        Iterator iterator = temp.iterator();
        Enumeration enumer = temp1.elements();

        HashMap<Integer, String> temp2 = new HashMap<>();

        HashSet<String>  obj1= new HashSet<>();
        obj1.add("dum");

        try {
            TreeSet<String> obj2 = new TreeSet<>();

            Set<String> ooo = new HashSet<>();

            Map<String, String> map = new HashMap<String, String>();
            BigInteger bigInteger;
            map.put("abc", "abc");


            Map<String, String> syncMap = Collections.synchronizedMap(map);

            syncMap.put("abc", "abc");

            System.out.println(a);
        }catch(NullPointerException ex){

        }


    }
}
