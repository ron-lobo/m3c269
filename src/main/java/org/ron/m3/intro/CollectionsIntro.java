package org.ron.m3.intro;

import org.apache.commons.collections4.list.TreeList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsIntro {

    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
//        ci.arrays();
        ci.lists();

        // Stack
    }

    private void lists() {
        System.out.println("\nLists\n-----");

        // ArrayList<String> list1 = new ArrayList<>(); // avoid!

        List<String> list1 = new ArrayList<>();
//        list1.add(1);
        list1.add("hi");
        list1.add("C269");
        useList("list1", list1);

        List<String> list2 = new TreeList<>();
        list2.add("hello");
        list2.add("cruel");
        list2.add("world");
        useList("list2", list2);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("goodbye");
        linkedList.add("cruel");
        linkedList.add("world");
        useList("linkedList", linkedList);
    }

    private void useList(String text, List<String> stringList) {
        System.out.printf("simple for loop - %s: ", text);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.printf("%d:%s, ", i, stringList.get(i));
        }
        System.out.println();

        stringList.add("End Item");
        stringList.add(0, "start item");

        System.out.printf("Java5 for loop - %s: ", text);
        for (String s : stringList) {
            System.out.printf("%s, ", s);
        }
        System.out.println();
        System.out.println();
    }

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
