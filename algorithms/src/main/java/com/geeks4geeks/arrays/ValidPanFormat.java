package com.geeks4geeks.arrays;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPanFormat {

    private static boolean isValidPAN(String s) {

        String pattern = "[A-Z]{5}\\d{4}[A-Z]{1}";
        String pattern2 = "(?i:.*\\bhackerrank\\b.*)";
        Pattern phoneNumber = Pattern
                .compile("^(\\d{1,3})[- ](\\d{1,3})[- ](\\d{4,10})$");
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);

        return m.matches();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int i = Integer.parseInt(br.readLine());
            for (int j = 0; j < i; j++) {
                String s = br.readLine();
                System.out.println(isValidPAN(s) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int containsHackerrank(String s) {

        String pattern = ".*\\b(HackerRank|hackerrank)\\b.*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);

        return (m.matches() ? 1 : 0);
    }

    private static void splitPhoneNo(String s) {

        Pattern phoneNumber = Pattern
                .compile("^(\\d{1,3})[- ](\\d{1,3})[- ](\\d{4,10})$");
        Matcher matcher = phoneNumber.matcher(s);

        if (matcher.matches()) {
            System.out.print("CountryCode=" + matcher.group(1));
            System.out.print(",LocalAreaCode=" + matcher.group(2));
            System.out.print(",Number=" + matcher.group(3));
            System.out.println();
        }

        Stack<Integer> stack = new Stack<>();


    }

}
