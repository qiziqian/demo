package com.example.qzq.socket.udp;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname UdpClient
 * @Description
 * @Date 2020/4/20 10:18
 * @Created by qiziqian
 */
public class UdpClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8989);//创建一个发送消息的套接字
            System.out.println("开始接收数据");
            while (true) {
                byte[] bytes = new byte[2048];
                DatagramPacket data = new DatagramPacket(bytes, bytes.length);//创建包接收信息
                socket.receive(data);//接收信息
                System.out.println("接收到数据包: " + printHexString(data.getData()));
            }
            // Socket.close();  //关闭套接字
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String printHexString(byte[] bytes) {

        int actualLength = bytes.length;
        while (bytes[actualLength - 1] == 0x00) {
            actualLength--;
        }
        String res = "";
        for (int i = 0; i < actualLength; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            res += hex.toUpperCase() + " ";
        }
        return res;
    }

}
