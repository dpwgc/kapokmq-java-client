# kapokmq-go-client

## KapokMQ.消息队列 Java客户端

### KapokMQ.消息队列源码

* https://github.com/dpwgc/kapokmq

* https://gitee.com/dpwgc/kapokmq

***

### 依赖导入

```xml
<dependencies>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.56</version>
    </dependency>
    <dependency>
         <groupId>org.java-websocket</groupId>
         <artifactId>Java-WebSocket</artifactId>
         <version>1.3.8</version>
    </dependency>
</dependencies>
```

***

### 使用方法

##### src/main/java/com.dpwgc.kapokmq/DemoApplication `演示Demo`

```java
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
```

***

### 项目结构

* com.dpwgc.kapokmq
  * conn
    * Cluster `获取集群节点列表`
    * ConsumerConn `消费者客户端连接`
    * ProducerConn `生产者客户端连接`
  * model
    * Message `消费者接收的消息模板`
    * Node `消息队列节点模板`
    * SendMessage `生产者发送的消息模板`
  * utils
    * HttpUtil `http请求工具`
    * JsonReadUtil `json字符串解析工具`
  * DemoApplication `演示Demo`

