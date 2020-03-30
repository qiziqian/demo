package com.example.qzq.proxyDemo.dynamic;


import com.example.qzq.proxyDemo.Apple;

/**
 * @Classname Client
 * @Description
 * @Date 2019/8/15 14:21
 * @Created by qiziqian
 */
public class Client {
    public static void main(String[] args) {
        FruitProxy fruitProxy = new FruitProxy();
        Apple proxy = (Apple) fruitProxy.newProxyInstance(new AppleImpl());
        proxy.buyByAgent("666");
    }
}
