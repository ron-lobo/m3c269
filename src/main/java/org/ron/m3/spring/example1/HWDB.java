package org.ron.m3.spring.example1;

public class HWDB {

    private RandomisationService rs = new RandomisationService();

    public String getCentre() {
        return rs.getRandInt(0, 10) < 5 ? "Cruel" : "Wonderful";
    }
}
