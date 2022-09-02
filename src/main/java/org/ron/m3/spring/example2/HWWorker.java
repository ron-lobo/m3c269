package org.ron.m3.spring.example2;

public class HWWorker {

    private HWService hwService;

    public HWWorker(HWService hwService) {
        this.hwService = hwService;
    }

    public String getMessage() {
        return hwService.getText();
    }
}
