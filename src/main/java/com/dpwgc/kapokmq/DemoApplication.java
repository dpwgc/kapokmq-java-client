package com.dpwgc.kapokmq;

import com.dpwgc.kapokmq.conn.Cluster;
import com.dpwgc.kapokmq.conn.ConsumerConn;
import java.net.URISyntaxException;
import java.util.List;

import com.dpwgc.kapokmq.conn.ProducerConn;
import com.dpwgc.kapokmq.model.Message;
import com.dpwgc.kapokmq.model.Node;
import com.dpwgc.kapokmq.utils.JsonReadUtil;
import org.java_websocket.WebSocket.READYSTATE;

/**
 * 演示Demo
 */
public class DemoApplication {

    public static void main(String[] args) throws URISyntaxException {

        /* Topic：主题，ConsumerId：消费者客户端id，ProducerId：生产者客户端id */
        /* 消费者websocket链接 ws://127.0.0.1:8011/Consumers/Conn/{Topic}/{ConsumerId} */
        /* 生产者websocket链接 ws://127.0.0.1:8011/Producers/Conn/{Topic}/{ProducerId} */

        //创建消费者客户端连接，并持续监听
        ConsumerConn consumerConn = new ConsumerConn("ws://127.0.0.1:8011/Consumers/Conn/java_topic/java1",""){

            /**
             * 持续监听消息队列发送过来的消息
             * @param msg 接收到的消息
             */
            @Override
            public void onMessage(String msg) {

                super.onMessage(msg);

                //如果是json字符串格式的消息
                if(msg.charAt(0) == '{'){
                    // TODO 监听消息队列发送的消息

                    //解析数据到Message类
                    Message message = JsonReadUtil.getMessage(msg);
                    System.out.println("MessageData: "+message.getMessageData());

                    // TODO 获取到message消息后，可在此进行业务操作
                }
            }
        };

        //创建生产者客户端连接
        ProducerConn producerConn = new ProducerConn("ws://127.0.0.1:8011/Producers/Conn/java_topic/java2","");

        //等待生产者客户端连接成功
        while(!producerConn.getReadyState().equals(READYSTATE.OPEN)){
            System.out.print(".");
        }
        System.out.println("\nproducer connect success");

        //等待消费者客户端连接成功
        while(!consumerConn.getReadyState().equals(READYSTATE.OPEN)){
            System.out.print(".");
        }
        System.out.println("\nconsumer connect success");

        //生产者循环发送消息
        for(int i=0;i<10;i++){
            //消息发送
            producerConn.ProducerSend("hi-"+i,0);
        }


        //通过向注册中心发送HTTP请求，获取集群内的消息队列节点列表
        List<Node> nodes = Cluster.GetNodes("http://127.0.0.1:8031/Registry/GetNodes","");
        System.out.println(nodes);

    }
}
