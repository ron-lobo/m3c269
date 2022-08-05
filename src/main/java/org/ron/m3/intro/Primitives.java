package org.ron.m3.intro;

public class Primitives {

    public static void main(String[] args) {
        basicPrimitives();
        primitiveWrappers();
    }

    private static void primitiveWrappers() {

        Byte by;
        Short s;
        Integer i = 3;
        Long l;
        Float f;
        Double d = 6.28;
        Boolean b = negate(Boolean.TRUE);
        Character c;

        System.out.println("i=" + i);
        System.out.println("d=" + d);
    }

    public static void basicPrimitives() {

        byte by;                    // 1 byte   (8 bits)     -128 .. 127
        short s;                    // 2 bytes (16 bits)     -32768 .. 32767
        int i = 5;                  // 4 bytes (32 bits)     -2.1B .. 2.1B
        long l;                     // 8 bytes (64 bits)     +/-10^19

        float f;                    // 4 bytes (32 bits)
        double d = 3.14;            // 8 bytes (64 bits)

        boolean b = negate(false);  // 1 bit
        char c;                     // 2 bytes  (unicode)

        System.out.println("i=" + i);
        System.out.println("d=" + d);
    }

    public static Boolean negate(boolean b) {
        return !b;
    }
}
