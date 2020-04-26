package com.example.qzq.socket.websocket;

/**
 * @Classname WebSocketMapUtil
 * @Description
 * @Date 2020/4/20 13:21
 * @Created by qiziqian
 */

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WebSocketMapUtil {

    public static ConcurrentMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    public static void put(String key, WebSocketServer myWebSocketServer) {
        webSocketMap.put(key, myWebSocketServer);
    }

    public static WebSocketServer get(String key) {
        return webSocketMap.get(key);
    }

    public static void remove(String key) {
        webSocketMap.remove(key);
    }

    public static Collection<WebSocketServer> getValues() {
        return webSocketMap.values();
    }
}