package org.ron.m3.spring.example2;

public class HelloWorldServer {

    private HWWorker hwWorker;

    public static void main(String[] args) {
        HWHelperImpl hwHelper = new HWHelperImpl(new DepAImpl(), new HWDBImpl());
        HWServiceImpl hwService = new HWServiceImpl(hwHelper);
        HWWorker hwWorker = new HWWorker(hwService);
        HelloWorldServer helloWorldServer = new HelloWorldServer(hwWorker);

        String message = helloWorldServer.sayHi();
        System.out.println(message);
    }

    public HelloWorldServer(HWWorker hwWorker) {
        this.hwWorker = hwWorker;
    }

    public String sayHi() {
        return hwWorker.getMessage();
    }
}
