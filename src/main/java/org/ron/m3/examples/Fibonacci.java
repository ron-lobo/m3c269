package org.ron.m3.examples;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a number: ");
            int pos = scanner.nextInt();
            long result = getItemInSeries(pos);
            System.out.println("result = " + result);
        }
    }

    public static long getItemInSeries(int pos) {
        if (pos <= 2) {
            return 1;
        }
        long x = 1, y = 1;
        for (int i = 0; i < pos - 3; i++) {
            long z = x + y;
            x = y;
            y = z;
        }
        return x + y;
    }

//    // [0,] 1, 1, 2, 3, 5, 8, 13, 21, ...
//    public static int getItemInSeries_01(int pos) {
//        int[] results = new int[]{1, 1, 2, 3, 5};
//        return results[pos];
//    }
}
