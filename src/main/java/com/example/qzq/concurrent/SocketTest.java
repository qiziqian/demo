package com.example.qzq.concurrent;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Classname SocketTest
 * @Description
 * @Date 2020/6/15 9:51
 * @Created by qiziqian
 */
public class SocketTest {
    private static DatagramSocket socket;

    static {
        try {
            socket = new DatagramSocket(6666);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("111");
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] bytes = new byte[10];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                try {
                    socket.receive(datagramPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "receivedThread-1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] bytes = new byte[10];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                try {
                    socket.receive(datagramPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "receivedThread-2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] bytes = new byte[10];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                try {
                    socket.receive(datagramPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "receivedThread-3").start();
    }
}
