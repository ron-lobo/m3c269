package org.ron.m3.spring.example1;

public class HelloWorldServer {

    public static void main(String[] args) {
        HelloWorldServer helloWorldServer = new HelloWorldServer();
        String message = helloWorldServer.sayHi();
        System.out.println(message);
    }

    public String sayHi() {
        HWWorker hwWorker = new HWWorker();
        return hwWorker.getMessage();
    }
}
