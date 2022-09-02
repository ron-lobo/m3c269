package org.ron.m3.spring.example3;

public class HelloWorldServer {

    private HWWorker hwWorker;

    public HelloWorldServer(HWWorker hwWorker) {
        this.hwWorker = hwWorker;
    }

    public String sayHi() {
        return hwWorker.getMessage();
    }
}
