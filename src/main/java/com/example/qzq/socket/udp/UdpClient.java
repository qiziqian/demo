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
        DatagramSocket socket = new DatagramSocket(8000);//创建一个发送消息的套接字
        byte[] frames = {0x01, 0x03, 0x00, 0x00, 0x00, 0x02, (byte) 0xC4, 0x0B};
        DatagramPacket packet = new DatagramPacket(frames, frames.length, InetAddress.getByName("192.168.42.247"), 502);
        while (true) {
            System.out.println("发包中...");
            socket.send(packet);

            byte[] bytes = new byte[20];
            DatagramPacket data = new DatagramPacket(bytes, bytes.length);//创建包接收信息
            socket.receive(data);//接收信息
            convertAndWrap(data);
            for (byte datum : data.getData()) {
                System.out.print(datum + " ");
            }
            System.out.println();
            Arrays.fill(bytes, (byte) 0);
            Thread.sleep(3000);
        }

    }

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
