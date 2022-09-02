package org.ron.m3.spring.example1;

public class HWHelper {

    public String assembleMessage() {
        DepA depA = new DepA();
        HWDB hwDB = new HWDB();

        String s = depA.getMsgStart();
        String e = depA.getMsgEnd();
        String c = hwDB.getCentre();
        return s + " " + c + " " + e;
    }
}
