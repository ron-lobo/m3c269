package org.ron.m3.spring.example1;

public class HWService {

    public String getText() {
        HWHelper hwHelper = new HWHelper();
        return hwHelper.assembleMessage();
    }
}
