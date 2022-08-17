package org.ron.m3.intro;

import java.util.ArrayList;

public class CollectionsIntro {

    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
//        ci.arrays();
        ci.lists();
    }

    private void lists() {
        System.out.println("\nLists\n-----");

        ArrayList<String> list = new ArrayList<String>();

//        list.add(1);
        list.add("hi");
        list.add("C269");

        System.out.print("simple for loop - list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d:%s, ", i, list.get(i));
        }
        System.out.println();

        System.out.print("Java5 for loop - list: ");
        for (String s : list) {
            System.out.printf("%s, ", s);
        }
        System.out.println();

    }
    // Stack

    private void arrays() {
        System.out.println("\nArrays\n------");

        int[] values1 = new int[]{9, 0, 1, 2, 5};
        int[] values2 = new int[4];

        values2[2] = 999;
        values2[0] = 777;

        System.out.printf("array values2: length=%d, item[0]=%d %n", values2.length, values2[0]);

        System.out.print("simple for loop - values1: ");
        for (int i = 0; i < values1.length; i++) {
            System.out.printf("%d:%d ", i, values1[i]);
        }

        System.out.print("\nJava5 for loop - values1: ");
        for (int val : values1) {
            System.out.print(val + " ");
        }

        String strings[] = new String[3];
        System.out.print("\nJava5 for loop: strings: ");
        for (String s : strings) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }
}
