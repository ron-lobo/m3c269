package org.ron.m3.spring.example3;

public class HWWorker {

    private HWService hwService;

    public HWWorker(HWService hwService) {
        this.hwService = hwService;
    }

    public String getMessage() {
        return hwService.getText();
    }
}
