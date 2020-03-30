package com.example.qzq.proxyDemo.stic;


import com.example.qzq.proxyDemo.Apple;

/**
 * @Classname AppleImpl
 * @Description
 * @Date 2019/8/15 14:23
 * @Created by qiziqian
 */
public class AppleImpl implements Apple {
    @Override
    public void buyByAgent(String s) throws NullPointerException {
        System.out.println("买了" + s + "个苹果");
    }
}
