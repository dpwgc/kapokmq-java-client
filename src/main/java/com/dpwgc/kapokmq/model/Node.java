package com.dpwgc.kapokmq.model;

// Node 消息队列服务节点结构体
public class Node {
    private String Name; //节点名称："mq:127.0.0.1:8011"
    private String Addr; //节点ip地址
    private String Port; //节点http服务端口号

    public void setName(String name) {
        Name = name;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public void setPort(String port) {
        Port = port;
    }

    public String getName() {
        return Name;
    }

    public String getAddr() {
        return Addr;
    }

    public String getPort() {
        return Port;
    }
}
