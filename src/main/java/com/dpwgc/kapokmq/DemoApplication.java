package com.dpwgc.kapokmq;

import com.dpwgc.kapokmq.conn.ClusterConn;
import com.dpwgc.kapokmq.conn.ConsumerConn;

import java.net.URI;
import java.net.URISyntaxException;
import org.java_websocket.WebSocket.READYSTATE;

/**
 * 启动类
 */
public class DemoApplication {

    public static void main(String[] args) throws URISyntaxException {


        ConsumerConn consumerConn = new ConsumerConn(new URI("ws://127.0.0.1:8011/Consumers/Conn/test_topic/java1"),"");
        //consumerConn.send("此为要发送的数据内容");

        consumerConn.connect();

        //等待连接成功
        while(!consumerConn.getReadyState().equals(READYSTATE.OPEN)){
            System.out.println("loading...");
        }
        System.out.println("ok");


        ClusterConn clusterConn = new ClusterConn();
        System.out.println(clusterConn.GetNodes("http://127.0.0.1:8031/Registry/GetNodes",""));

        while (true) {

        }
    }

}
