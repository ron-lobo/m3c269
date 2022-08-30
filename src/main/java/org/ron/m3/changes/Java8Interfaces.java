package org.ron.m3.changes;

import java.time.LocalDateTime;

import static org.ron.m3.changes.Utils.print;
import static org.ron.m3.changes.Utils.printMethod;

public class Java8Interfaces {

    public static void main(String[] args) {
        printMethod("Features Introduced in Java 8: Interfaces()");

        Java8Interface.hiWorld("new interface");
    }

    public interface Java8Interface {

        // static methods - these must be defined in the interface and cannot be overridden
        static String hiWorld(String s) {
            return print("hi", s, "world");
        }

        void method(String str);

        void method(int i);

        void method(double d, boolean b);

        // A method with an implementation (which can be overridden).
        default void log(String str, int level) {
            LocalDateTime now = LocalDateTime.now();
            print(now, "Level", level, ":", str);
        }

//        default String toString() {
//            return "These are not the defaults you are looking for";
//        }
    }


    @FunctionalInterface
    private interface Hello {
        String hi();
    }


    public interface Greeting {
        void hi();
    }

    public interface USGreeting extends Greeting {
        @Override
        default void hi() {
            System.out.println("howdy");
        }

        void m1();

        void m2();
    }

    public interface OzGreeting extends Greeting {
        default void hi() {
            System.out.println("g'day");
        }
    }

    public interface MyGreeting extends USGreeting, OzGreeting {
        default void hi() {
            USGreeting.super.hi();
            System.out.println("Hello");
            OzGreeting.super.hi();
        }
    }
}
