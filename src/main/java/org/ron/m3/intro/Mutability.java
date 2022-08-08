package org.ron.m3.intro;

public class Mutability {

    public static final double PI = 3.14;

    public static void main(String[] args) {
        m1(0);
    }

    public static void m1(int i) {
        System.out.println("Finals.m1()");

        int SUB_ACCOUNTS = 5;
        Integer mainAccounts = 7;
        String str = "Hi";
        StringBuilder sb = new StringBuilder("Hello");

        System.out.println("    BEFORE calling m2()");
        System.out.println("SUB_ACCOUNTS = " + SUB_ACCOUNTS);
        System.out.println("mainAccounts = " + mainAccounts);
        System.out.println("sb = " + sb);
        System.out.println("str = " + str);

        m2(SUB_ACCOUNTS, mainAccounts, str, sb);

        System.out.println("    AFTER");
        System.out.println("SUB_ACCOUNTS = " + SUB_ACCOUNTS);
        System.out.println("mainAccounts = " + mainAccounts);
        System.out.println("sb = " + sb);
        System.out.println("str = " + str);

//        str += " world";
        str = str + " world";
        mainAccounts++;
        mainAccounts += 5;
        System.out.println("str = " + str +  ", mainAccounts = " + mainAccounts);
    }

    public static void m2(int i, Integer j, String str, StringBuilder sb) {
        i = 99;
        j = 999;
        sb.append(" World");
//        sb = new StringBuilder("hi World");
        str += " there";
    }
}
