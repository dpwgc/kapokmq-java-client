package com.dpwgc.kapokmq.conn;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import com.dpwgc.kapokmq.model.Message;
import com.dpwgc.kapokmq.utils.JsonReadUtil;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

/**
 * 消费者连接
 */
public class ConsumerConn extends WebSocketClient {

    //消息队列访问密钥
    String secretKey;

    /**
     * 建立消费者客户端连接
     * @param wsUrl websocket链接
     * @param secretKey 安全访问密钥
     */
    public ConsumerConn(String wsUrl,String secretKey) throws URISyntaxException {
        super(new URI(wsUrl));
        this.secretKey = secretKey;
        connect();
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        System.out.println("ConsumerConn onOpen");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        System.out.println("ConsumerConn onClose");
    }

    @Override
    public void onError(Exception e) {
        System.out.println("ConsumerConn onError: "+e);
    }

    @Override
    public void onMessage(String msg) {

        //服务端提示输入访问密钥
        if(msg.equals("Please enter the secret key")){
            //发送访问密钥
            send(secretKey.getBytes(StandardCharsets.UTF_8));
            return;
        }
        //如果访问密钥错误
        if(msg.equals("Secret key matching error")){
            //关闭连接
            close();
            return;
        }
        //访问密钥正确
        if(msg.equals("Secret key matching succeeded")){
            System.out.println(msg);
        }
    }

}
