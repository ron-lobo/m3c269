package org.ron.m3.spring.example3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HWHelperImpl implements HWHelper {

    private DepA depA;
    private HWDB hwDB;

    public HWHelperImpl(DepA depA, HWDB hwDB) {
        this.depA = depA;
        this.hwDB = hwDB;
    }

    @Autowired
    public HWHelperImpl(DepA depA) {
        this.depA = depA;
    }

    @Autowired
    public void setHwDB(HWDB hwDB) {
        this.hwDB = hwDB;
    }

    public String assembleMessage() {
        String s = depA.getMsgStart();
        String e = depA.getMsgEnd();
        String c = hwDB.getCentre();
        return s + " " + c + " " + e;
    }
}
