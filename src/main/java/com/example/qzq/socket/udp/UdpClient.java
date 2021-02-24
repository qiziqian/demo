package com.example.qzq.socket.udp;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/**
 * @Classname UdpClient
 * @Description
 * @Date 2020/4/20 10:18
 * @Created by qiziqian
 */
public class UdpClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket socket = new DatagramSocket(4196);//创建一个发送消息的套接字
        byte[] frames = {0x01, 0x03, 0x00, 0x00, 0x00, 0x02, (byte) 0xC4, 0x0B};
        //DatagramPacket packet = new DatagramPacket(frames, frames.length, InetAddress.getByName("192.168.42.247"), 502);
        while (true) {
            // System.out.println("发包中...");
            //  socket.send(packet);

            byte[] bytes = new byte[20];
            DatagramPacket data = new DatagramPacket(bytes, bytes.length);//创建包接收信息
            socket.receive(data);//接收信息
            //convertAndWrap(data);
            //  System.out.println("收到数据长度:"+data.getLength());
            verifyData("gate1", data);
            System.out.println("标签:" + getTag(data.getData()) + " 状态: " + getStatus(data.getData()) + " 激活器: " + getActiveId(data.getData()) + " 激活强度: " + getRssi(data.getData()));
//            for (byte datum : data.getData()) {
//                System.out.print(datum + " ");
//            }
//            System.out.println();
            Arrays.fill(bytes, (byte) 0);

        }

    }

    public static boolean verifyData(String code, DatagramPacket data) {
        int length = data.getLength();
        if (length != 5 && length != 12) return false;
        byte[] realData = Arrays.copyOfRange(data.getData(), 0, length);
        int crc = realData[length - 1];
        int crcTest = 0;
        for (int i = 0; i < length - 1; i++) {
            crcTest ^= realData[i];
        }
        boolean success = crc == crcTest;

        if (!success) System.out.println("读写器: " + code + " 数据校验未通过:" + HexBin.encode(realData));
        return success;
    }

    public static int getTag(byte[] bytes) {
        byte[] realData = Arrays.copyOfRange(bytes, 4, 7);
        String encode = HexBin.encode(realData);
        int tag = Integer.parseInt(encode, 16);
        return tag;
    }

    public static boolean getStatus(byte[] bytes) {
        byte[] realData = Arrays.copyOfRange(bytes, 7, 8);
        return realData[0] == (byte) 128;
    }

    public static int getActiveId(byte[] bytes) {
        byte[] realData = Arrays.copyOfRange(bytes, 8, 10);
        int high = (realData[0] & 0b00111111) << 8;
        int low = realData[1];
        return high + low;
    }

    public static int getRssi(byte[] bytes) {
        return bytes[10];
    }

    //02168F    2 22 -113
    public static void convertAndWrap(DatagramPacket data) {
        //拿到指定数据位
        byte[] humidityBytes = Arrays.copyOfRange(data.getData(), 3, 5);
        byte[] temperatureBytes = Arrays.copyOfRange(data.getData(), 5, 7);
        //转换和封装数据
        double humidity = (double) convert(humidityBytes) / 10;
        double temperature = (double) convert(temperatureBytes) / 10;
        System.out.println("当前温度" + temperature + ", 当前湿度" + humidity);
    }

    //温湿度数据格式转换
    public static int convert(byte[] bytes) {
        int i = 0;
        if (bytes[0] != -1) {
            String encode = HexBin.encode(bytes);
            i = Integer.parseInt(encode, 16);
        } else {
            i = bytes[1];
        }
        return i;
    }

}
