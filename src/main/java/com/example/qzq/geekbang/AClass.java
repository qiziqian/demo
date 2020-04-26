package com.example.qzq.geekbang;

/**
 * @Classname AClass  回调函数->实现复用和扩展
 * @Description
 * @Date 2020/4/10 16:11
 * @Created by qiziqian
 */
public class AClass {

    public interface ICallback {
        void methodToCallback();
    }

    public static class BClass {
        public void process(ICallback callback) {
            //...
            callback.methodToCallback();
            //...
        }
    }

    public static void main(String[] args) {
            BClass b = new BClass();
            b.process(new ICallback() { //回调对象
                @Override
                public void methodToCallback() {
                    System.out.println("Call back me.");
                }
            });
        }

}
