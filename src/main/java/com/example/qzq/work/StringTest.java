package com.example.qzq.work;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Classname StringTest
 * @Description
 * @Date 2020/2/4 10:17
 * @Created by qiziqian
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "";
        String[] split = s.split(",");
        System.out.println(split.length);
        int i = 0x0f;

        System.out.println(i);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(666);
            }
        }, new Date(), 1000);
    }
}
