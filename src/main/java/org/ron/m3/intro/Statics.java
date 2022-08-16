package org.ron.m3.intro;

public class Statics {

    private String name;
    private int numBuses;
    private int numPlanes;

    private static String HQ = setHQ();
    private static int i;
    private static double d;

    static {
        i = Primitives.negate(true) ? 1 : 3;
        d = 22 / 7.0 * i;
    }

    public static void main(String[] args) {
        Statics company1 = new Statics("Company1", 10, 2);
        Statics company2 = new Statics("Company2", 20, 7);

        company1.printout();
        company2.printout();

        company1.numPlanes++;
        company2.numBuses -= 2;
        HQ = "Berlin";

        System.out.println();
        company1.printout();
        company2.printout();
    }

    public Statics(String name, int buses, int planes) {
        this.name = name;
        this.numBuses = buses;
        this.numPlanes = planes;
    }

    public void printout() {
        System.out.printf("%1$s: numBuses=%2$d, numPlanes=%3$d, HQ=%4$s %n", name, numBuses, numPlanes, HQ);
    }

    private static String setHQ() {
        // ...
        // ...
        return "London";
    }

    public static void testEquality(String text, Object obj1, Object obj2) {
        System.out.println("comparing: " +  text);
        System.out.println("equals() method: " + (obj1.equals(obj2) ? "same" : "different"));
        System.out.println("== operator    : " + (obj1 == obj2 ? "same" : "different"));
    }
}
