package org.ron.m3.spring.example3;

import org.springframework.stereotype.Repository;

@Repository
public class HWDBImpl implements HWDB {

    private RandomisationService rs = new RandomisationService();

    public String getCentre() {
        return rs.getRandInt(0, 10) < 5 ? "Cruel" : "Wonderful";
    }
}
