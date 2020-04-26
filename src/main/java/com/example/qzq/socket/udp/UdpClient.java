package com.example.qzq.socket.udp;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname UdpClient
 * @Description
 * @Date 2020/4/20 10:18
 * @Created by qiziqian
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
            try {
                DatagramSocket Socket = new DatagramSocket(7777);//创建一个发送消息的套接字
                byte[] bytes = {0x02, (byte) 0x92, (byte) 0xFF, (byte) 0x9B};
                InetAddress ip = InetAddress.getByName("127.0.0.1");//接收内容的Ip地址
                DatagramPacket Packet = new DatagramPacket(bytes, bytes.length, ip, 9001); //创建要发送的数据包，然后用套接字发送
                Socket.send(Packet); //用套接字发送数据包
                receiver(Socket);//调用receiver方法，接收客户端回馈的信息
                Socket.close();  //关闭套接字
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    static void  receiver(DatagramSocket Socket) throws IOException{  //构建接收客户端信息的方法
        byte[] byte01=new byte[2048];
        DatagramPacket data=new DatagramPacket(byte01,byte01.length);//创建包接收信息
        Socket.receive(data);//接收信息

        byte[] array1 = Arrays.copyOfRange(data.getData(), 0, 2);
        byte[] array2 = Arrays.copyOfRange(data.getData(), 2, 4);

        double complement1 = (double) complement(array1) / 10;
        double complement2 = (double) complement(array2) / 10;
        System.out.println("湿度为:"+complement1);
        System.out.println("温度为:"+complement2);
    }

    public static int complement(byte[] bytes) {
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
