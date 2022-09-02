package org.ron.m3.spring.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class HelloWorldConfig {

    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorldServer helloWorldServer = appContext.getBean(HelloWorldServer.class);
        System.out.println(helloWorldServer.sayHi());
    }

    @Bean
    public HelloWorldServer getHelloWorldServer(HWWorker hwWorker) {
        return new HelloWorldServer(hwWorker);
    }

    @Bean
    public HWWorker getHWW(HWService hwService) {
        return new HWWorker(hwService);
    }

    @Bean
    public HWService getHWS(HWHelper hwHelper) {
        return new HWServiceImpl(hwHelper);
    }

    @Bean
    public HWHelper getHWH(DepA depA, HWDB hwDB) {
        return new HWHelperImpl(depA, hwDB);
    }

    @Bean
    public DepA getDepA() {
        return new DepAImpl();
    }

    @Bean
    public HWDB getHWDB() {
        return new HWDBImpl();
    }
}
