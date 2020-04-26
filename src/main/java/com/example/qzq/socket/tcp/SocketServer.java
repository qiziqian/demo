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
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        String s ;
        int i  =1;
        while ((len = inputStream.read(bytes)) != -1){
            String message = "来自 server 的消息 "+i;
            outputStream.write(message.getBytes("UTF-8"));
           // len = inputStream.read(bytes);
           // System.out.println("输入流长度: "+len);
                //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
             //   s= new String(bytes, 0, len,"UTF-8");
              //  System.out.println("get message from client: " + s);
              //  outputStream.write("你好 socket client".getBytes("UTF-8"));
            i++;
            Thread.sleep(2000);

        }



//        inputStream.close();
//        outputStream.close();
//        socket.close();
//        server.close();

    }
}
