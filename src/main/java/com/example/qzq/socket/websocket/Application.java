package com.example.qzq.socket.websocket;

import org.java_websocket.WebSocket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @Classname Application
 * @Description
 * @Date 2020/4/20 13:37
 * @Created by qiziqian
 */
public class Application {
    public static void main(String[] arg0) throws URISyntaxException {
        new ArrayList<>();
        MyWebSocketClient myClient = new MyWebSocketClient(new URI("ws://127.0.0.1:8885/websocket"));
        // 往websocket服务端发送数据
        myClient.connect();
        while(!myClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
            System.out.println("正在连接...");
        }
        myClient.send("此为要发送的数据内容");

    }
}
