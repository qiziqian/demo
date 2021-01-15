package com.example.qzq.socket.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Classname SocketServer
 * @Description
 * @Date 2020/4/15 15:11
 * @Created by qiziqian
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        // 监听指定的端口
        int port = 8088;
        ServerSocket server = new ServerSocket(port);
        System.out.println("开始监听");
        Socket socket = server.accept();
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("你好 客户端");
        out.flush();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println("收到数据:" + new String(bytes, 0, len, StandardCharsets.UTF_8));
            // socket.shutdownOutput();
        }


        inputStream.close();
        socket.close();
        server.close();

    }
}
