package org.ron.m3.spring.example2;

public class HWServiceImpl implements HWService {

    private HWHelper hwHelper;

    public HWServiceImpl(HWHelper hwHelper) {
        this.hwHelper = hwHelper;
    }

    public String getText() {
        return hwHelper.assembleMessage();
    }
}
