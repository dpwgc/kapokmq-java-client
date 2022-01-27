package com.dpwgc.kapokmq.conn;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

/**
 * 消费者连接
 */
public class ConsumerConn extends WebSocketClient {

    String secretKey;

    /**
     * 建立消费者客户端连接
     * @param wsUrl websocket链接
     * @param secretKey 安全访问密钥
     */
    public ConsumerConn(URI wsUrl,String secretKey) {
        super(wsUrl);
        this.secretKey = secretKey;
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        System.out.println("WebSocket onOpen");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        System.out.println("WebSocket onClose");
    }

    @Override
    public void onError(Exception arg0) {
        System.out.println("WebSocket onError");
    }

    @Override
    public void onMessage(String arg0) {
        //输入访问密钥
        if(arg0.equals("Please enter the secret key")){
            send(secretKey.getBytes(StandardCharsets.UTF_8));
        }
        System.out.println(arg0);
    }

}
