package com.example.qzq.proxyDemo.stic;

/**
 * @Classname Client
 * @Description
 * @Date 2019/8/15 14:21
 * @Created by qiziqian
 */
public class Client {
    public static void main(String[] args) {
        pearProxy();
    }

    public static void appleProxy() {
        AppleImplProxy proxy = new AppleImplProxy(new AppleImpl());
        proxy.buyByAgent(null);
    }

    public static void pearProxy() {

        PearImplProxy proxy = new PearImplProxy(new PearImpl());
        proxy.buyByAgent("777");
    }
}
