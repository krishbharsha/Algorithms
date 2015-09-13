package com.geeks4geeks.arrays;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();

        if(tests>0 && tests <=10){
            while(tests > 0) {
                String str1 = scan.next();
                String str2 = scan.next();
                int len1 = str1.length();
                int len2 = str2.length();

                if ((len1 > 0 && len1 <= Math.pow(10, 5))
                        && (len2 > 0 && len2 <= Math.pow(10, 5))) {

                    Set<Character> setChar1 = new HashSet();
                    Set<Character> setChar2 = new HashSet();

                    int len = Math.min(len1, len2);
                    for (int m = 0; m < len; m++) {

                        if (setChar1.contains(str2.charAt(m)) ||
                                setChar2.contains(str1.charAt(m))) {
                            System.out.println("YES");
                            break;
                        } else {
                            setChar1.add(str1.charAt(m));
                            setChar2.add(str2.charAt(m));
                        }

                        if (m == (len - 1)) {
                            System.out.println("NO");
                        }
                    }
                }
                tests--;
            }
        }

    }
}
