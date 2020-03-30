package com.example.qzq.proxyDemo.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname FruitProxy
 * @Description
 * @Date 2019/8/15 14:42
 * @Created by qiziqian
 */
public class FruitProxy implements InvocationHandler {

    private Object proxy;

    public Object newProxyInstance(Object o) {
        this.proxy = o;
        return Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
                proxy.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始");

        method.invoke(proxy, args);
        System.out.println("动态代理结束");
        return null;
    }
}
