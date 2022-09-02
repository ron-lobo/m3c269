package org.ron.m3.spring.example1;

public class HWWorker {

    public String getMessage() {
        HWService hwService = new HWService();
        return hwService.getText();
    }
}
