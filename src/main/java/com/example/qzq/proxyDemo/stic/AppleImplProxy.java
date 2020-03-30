package com.example.qzq.proxyDemo.stic;


import com.example.qzq.proxyDemo.Apple;

/**
 * @Classname AppleImplProxy
 * @Description 静态代理的代理类
 * @Date 2019/8/15 14:25
 * @Created by qiziqian
 */
public class AppleImplProxy implements Apple {

    private Apple apple;

    public AppleImplProxy(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void buyByAgent(String s) {
        try {
            System.out.println("代理类执行开始");
            apple.buyByAgent(s);
            System.out.println("代理类执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("代理类执行异常");
        }
    }
}
