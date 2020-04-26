package com.example.qzq.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Classname UdpServer
 * @Description
 * @Date 2020/4/20 10:18
 * @Created by qiziqian
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket Socket = new DatagramSocket(9001, InetAddress.getByName("127.0.0.1")); //创建接收消息的套接字，端口和ip要与服务端指定的一致
        byte[] bytes = new byte[2048];
        DatagramPacket Packet = new DatagramPacket(bytes, bytes.length); //创建一个数据包来接收消息
        while (true) {
            try {
                Socket.receive(Packet);//接收数据包
                String rec = new String(Packet.getData());//将接收的信息转换为String
                System.out.println("服务端接收到的消息：" + rec);
                byte[] send = {0x02, (byte) 0x92, (byte) 0xFF, (byte) 0x9B};
                DatagramPacket data = new DatagramPacket(send, send.length, Packet.getSocketAddress());//创建发送信息的包，指定给发送者socketAddress(ip和指定端口 )
                Socket.send(data);//发送数据包

            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Socket.close();//关闭套接字
    }
}
