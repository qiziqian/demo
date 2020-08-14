package com.example.qzq.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Classname SocketServer
 * @Description
 * @Date 2020/4/15 15:11
 * @Created by qiziqian
 */
public class SocketServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 监听指定的端口
        int port = 8888;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len, "UTF-8"));
            // socket.shutdownOutput();
        }


        //inputStream.close();
        //outputStream.close();
        // socket.close();
        // server.close();

    }
}
