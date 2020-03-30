package com.example.qzq.proxyDemo.dynamic;


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
        if (null == s) {
            throw new NullPointerException("数量不能为空");
        }
        System.out.println("买了" + s + "个苹果");
        //   return "买了"+s +"个苹果";
    }
}
