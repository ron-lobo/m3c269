package org.ron.m3.intro;

import org.apache.commons.collections4.list.TreeList;

import java.util.*;

public class CollectionsIntro {

    private Random random = new Random();

    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
        ci.arrays();
        ci.lists();             // ordered, may contain duplicates
        ci.sets();              // unordered, contain no duplicates
    }

    private void sets() {
        System.out.println("\nSets\n----");

        Set<String> stringSet1 = new HashSet<>();
        Set<String> stringSet2 = new TreeSet<>();

        populateSet(stringSet1);
        populateSet(stringSet2);
        populateSet(stringSet2);
        populateSet(stringSet2);

        showSet("stringSet1", stringSet1);
        showSet("stringSet2", stringSet2);
    }

    private void showSet(String text, Set<String> strings) {
        System.out.println("Set " + text + ": " + strings.size() + " items");
        for (String s : strings) {
            System.out.print(s + ", ");
        }
        System.out.println();
        for (Iterator<String> iter = strings.iterator(); iter.hasNext(); ) {
            String s = iter.next();
            System.out.print(s + ", ");
            if (random.nextDouble() < 0.33) {
                iter.remove();                  // safe way to remove elements while looping/iterating
            }
        }
        System.out.println("   final size: " + strings.size() + " items");
        System.out.println();
    }

    private void populateSet(Set<String> strings) {
        strings.add("hello");
        strings.add("gday");
        strings.add("hi");
        strings.add("goodbye");
        strings.add("farewell");
        strings.add("bye");
    }

    private void lists() {
        System.out.println("\nLists\n-----");

        // ArrayList<String> list1 = new ArrayList<>(); // avoid!

        List<String> list1 = new ArrayList<>();
//        list1.add("hi");
//        list1.add("C269");
        useList("list1", list1);

        List<String> list2 = new TreeList<>();
        list2.add("hello");
        list2.add("wonderful");
        list2.add("world");
        useList("list2", list2);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("goodbye");
        linkedList.add("cruel");
        linkedList.add("world");
        useList("linkedList", linkedList);
    }

    private void useList(String text, List<String> list) {
        String sizeInfo = "Initial size = " + list.size();
        System.out.println("'world' in list? " + list.contains("hello"));
        System.out.printf("simple for loop - %s: ", text);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d:%s, ", i, list.get(i));
        }
        System.out.println();

        if (list.size() > 1) {
            list.remove(1);
        }
        list.add("End Item");
        list.add(0, "start item");

        System.out.printf("Java5 for loop - %s: ", text);
        for (String s : list) {
            System.out.printf("%s, ", s);
//            if (list.size() > 0) {
//                list.remove(0);       // beware!
//            }
        }
        System.out.println();
        System.out.println(sizeInfo);
        System.out.println("final size = " + list.size());
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
