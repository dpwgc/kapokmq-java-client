package com.dpwgc.kapokmq.conn;

import com.alibaba.fastjson.JSONObject;
import com.dpwgc.kapokmq.model.SendMessage;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;


/**
 * 生产者连接
 */
public class ProducerConn extends WebSocketClient {

    //消息队列访问密钥
    String secretKey;

    /**
     * 建立生产者客户端连接
     * @param wsUrl websocket链接
     * @param secretKey 安全访问密钥
     */
    public ProducerConn(String wsUrl,String secretKey) throws URISyntaxException {
        super(new URI(wsUrl));
        this.secretKey = secretKey;
        connect();
    }

    /**
     * 生产者发送消息到消息队列
     * @param messageData 消息主体（一般为json字符串）
     * @param delayTime 延时{delayTime}秒后推送
     * @return boolean
     */
    public boolean ProducerSend(String messageData,int delayTime){

        //将消息封装成SendMessage类
        SendMessage sendMessage = new SendMessage();
        sendMessage.setMessageData(messageData);
        sendMessage.setDelayTime(delayTime);

        //将SendMessage类转为json字符串
        String json = JSONObject.toJSONString(sendMessage);

        //发送消息
        send(json.getBytes(StandardCharsets.UTF_8));

        return true;
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        System.out.println("ProducerConn onOpen");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        System.out.println("ProducerConn onClose");
    }

    @Override
    public void onError(Exception e) {
        System.out.println("ProducerConn onError: "+e);
    }

    @Override
    public void onMessage(String arg0) {
        //输入访问密钥
        if(arg0.equals("Please enter the secret key")){
            send(secretKey.getBytes(StandardCharsets.UTF_8));
        }
        //如果访问密钥错误
        if(arg0.equals("Secret key matching error")){
            //关闭连接
            close();
        }
    }

}
