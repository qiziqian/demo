package com.example.qzq.游戏编程模式;

/**
 * @ClassName : Stage
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-09 16:19
 */
public class Stage {

    Actor[] array = new Actor[3];

    public Stage() {
        array[0] = new Actor();
        array[0] = new Actor();
        array[0] = new Actor();
    }

    public void update() {
        for (int i = 0; i < array.length; i++) {
            array[i].update();
            array[i].reset();
        }
    }

    public void update2() {
        for (int i = 0; i < array.length; i++) {
            array[i].update();
        }
        for (int i = 0; i < array.length; i++) {
            array[i].swap();
        }
    }
}