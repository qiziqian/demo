package com.example.qzq.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;


/**
 * @Classname SocketClient
 * @Description
 * @Date 2020/4/15 15:11
 * @Created by qiziqian
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        try {
            String ip = "192.168.42.242";
            int port = 1030;
//            String ip = "127.0.0.1";
//            int port = 8888;
            System.out.println("设置服务器路径 " + ip + ":" + port);

            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(ip, port);
            socket.connect(socketAddress, 3000);
            socket.setSoTimeout(3000);

            byte[] bytes = new byte[100];
            OutputStream outputStream = socket.getOutputStream();
            byte[] request = {0x48, 0x3a, 0x01, 0x57, 0x01, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xdc, 0x45, 0x44};
            outputStream.write(request);
            outputStream.flush();
            socket.shutdownOutput();

            int len;
            InputStream inputStream = socket.getInputStream();
            while ((len = inputStream.read(bytes)) != -1) {
                socket.shutdownInput();
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
