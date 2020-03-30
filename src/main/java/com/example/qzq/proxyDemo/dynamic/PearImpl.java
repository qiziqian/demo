package com.example.qzq.proxyDemo.dynamic;


import com.example.qzq.proxyDemo.Pear;

/**
 * @Classname PearImpl
 * @Description
 * @Date 2019/8/15 14:36
 * @Created by qiziqian
 */
public class PearImpl implements Pear {
    @Override
    public void buyByAgent(String s) {
        if (null == s) {
            throw new NullPointerException("数量不能为空");
        }
        System.out.println("买了" + s + "个梨");
    }
}
