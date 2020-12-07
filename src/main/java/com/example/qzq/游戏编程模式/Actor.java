package com.example.qzq.游戏编程模式;

/**
 * @ClassName : Actor
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-09 16:19
 */
public class Actor {

    boolean isSlapped;
    boolean next;
    Actor faced;

    public void update() {
        if (isSlapped) faced.slap();
    }

    public void slap() {
        next = true;
    }

    public void reset() {
        isSlapped = false;
    }

    public void swap() {
        isSlapped = next;
        next = false;
    }
}