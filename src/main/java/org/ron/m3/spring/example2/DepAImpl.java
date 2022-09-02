package org.ron.m3.spring.example2;

public class DepAImpl implements DepA {

    private RandomisationService rs = new RandomisationService();

    public String getMsgStart() {
        return rs.getRandInt(0, 2) == 0 ? "Hello" : "Bye";
    }

    public String getMsgEnd() {
        return rs.getRandInt(0, 2) == 0 ? "World" : "Life";
    }
}
