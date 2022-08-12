package org.ron.m3.examples;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int pos = scanner.nextInt();
        int result = getItemInSeries(pos);
        System.out.println("result = " + result);
    }

    // [0,] 1, 1, 2, 3, 5, 8, 13, 21, ...
    public static int getItemInSeries(int pos) {
        return -1;
    }
}
