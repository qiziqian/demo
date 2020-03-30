package com.example.qzq.proxyDemo.stic;


import com.example.qzq.proxyDemo.Pear;

/**
 * @Classname PearImplProxy
 * @Description
 * @Date 2019/8/15 14:37
 * @Created by qiziqian
 */
public class PearImplProxy implements Pear {

    private Pear pear;

    public PearImplProxy(Pear pear) {
        this.pear = pear;
    }

    @Override
    public void buyByAgent(String s) {
        try {
            System.out.println("代理类执行开始");
            pear.buyByAgent(s);
            System.out.println("代理类执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("代理类执行异常");
        }
    }
}
