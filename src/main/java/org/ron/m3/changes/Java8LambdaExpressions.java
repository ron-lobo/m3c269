package org.ron.m3.changes;

import static org.ron.m3.changes.Utils.print;
import static org.ron.m3.changes.Utils.printMethod;

public class Java8LambdaExpressions {

    public static final String INTRO_NAME = "Hi, I am";
    public static final String AND = "and";
    public static final String INTRO_JOB = "I am a";

    public static void main(String[] args) {
        printMethod("Features Introduced in Java 8: LambdaExpressions");
        Java8LambdaExpressions j8 = new Java8LambdaExpressions();
        j8.lambdaExpressions();
    }


    @FunctionalInterface
    private interface Intro0 {
        void introduce();
    }

    @FunctionalInterface
    private interface Intro1 {
        String introduce(String name);
    }

    private interface Intro2 {
        String introduce(String name, String job);
    }


    private class MyIntro2 implements Intro2 {
        public String introduce(String name, String job) {
            return print(INTRO_NAME, name, AND, INTRO_JOB, job);
        }
    }


    private void lambdaExpressions() {
        printMethod("lambdaExpressions");

        Intro2 objA = new MyIntro2();

        Intro2 objB = new Intro2() {
            @Override
            public String introduce(String name, String job) {
                return print(INTRO_NAME, name, AND, INTRO_JOB, job);
            }
        };

        Intro2 objL1 = (String name, String job) -> {
            return print(INTRO_NAME, name, AND, INTRO_JOB, job);
        };

        Intro2 objL2 = (name, job) -> {
            return print(INTRO_NAME, name, AND, INTRO_JOB, job);
        };

        Intro2 objL3 = (name, job) -> print(INTRO_NAME, name, AND, INTRO_JOB, job);

        Intro1 objL4 = name -> print(INTRO_NAME, name);

        Intro0 objL5 = () -> print(INTRO_NAME, "Anon E Mouse");

        // let's try using them:
        objA.introduce("Liz", "queen");
        objB.introduce("Florence", "machine");
        objL1.introduce("Francis", "pope");
        objL2.introduce("Donald", "dope");
        objL3.introduce("Justin", "chanteuse");
        objL4.introduce("Kim");
        objL5.introduce();
    }
}
