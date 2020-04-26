package com.example.qzq.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Classname SocketClient
 * @Description
 * @Date 2020/4/15 15:11
 * @Created by qiziqian
 */
public class SocketClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        String message = "你好 server ";
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        InputStream inputStream = socket.getInputStream();
        while ((len = inputStream.read(bytes)) != -1) {
            // outputStream.write(message.getBytes("UTF-8"));
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            String s = new String(bytes, 0, len, "UTF-8");
            System.out.println("get message from server: " + s);


        }


        //   outputStream.close();
        //   socket.close();

    }
}
