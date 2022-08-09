package org.ron.m3.intro;

public class Mutability {

    public static final double PI = 3.14;

    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        System.out.println("Finals.m1()");

        int i = 5;
        Integer i1 = 7;
        String str = "Hi";
        StringBuilder sb = new StringBuilder("Hello");

        showVariables("Before calling m2()", i, i1, str, sb);
        m2(i, i1, str, sb);
        showVariables("After calling m2()", i, i1, str, sb);

        str += " cruel";
        str = str + " world";
        i++;
        i1++;
        i1 += 5;
        showVariables("After reassignments", i, i1, str, sb);
    }

    private static void showVariables(String text, int i, Integer i1, String str, StringBuilder sb) {
//        System.out.println();
//        System.out.println(text);
//        System.out.println("i = " + i);
//        System.out.println("i1 = " + i1);
//        System.out.println("sb = " + sb);
//        System.out.println("str = " + str);

        System.out.printf("%5$s: i=%1$d, i1=%2$d, sb=%4$s, str=%3$s", i, i1, str, sb, text);
    }

    public static void m2(int i, Integer j, String str, StringBuilder sb) {
        i = 99;
        j = 999;
        sb.append(" World");
//        sb = new StringBuilder("hi World");
        str += " there";
    }
}
