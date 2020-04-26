package com.example.qzq.socket.websocket;

/**
 * @Classname MyWebSocketClient
 * @Description
 * @Date 2020/4/20 13:23
 * @Created by qiziqian
 */



import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class MyWebSocketClient extends WebSocketClient {


    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
// TODO Auto-generated method stub
        System.out.println("------ MyWebSocket onOpen ------");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        // TODO Auto-generated method stub
        System.out.println("------ MyWebSocket onClose ------");
    }

    @Override
    public void onError(Exception arg0) {
        // TODO Auto-generated method stub
        System.out.println("------ MyWebSocket onError ------");
    }

    @Override
    public void onMessage(String arg0) {
        // TODO Auto-generated method stub
        System.out.println("-------- 接收到服务端数据： " + arg0 + "--------");
    }
}