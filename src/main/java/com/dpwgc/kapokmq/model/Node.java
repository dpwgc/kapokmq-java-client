package com.dpwgc.kapokmq.model;

// Node 消息队列服务节点结构体
public class Node {
    private String Name;
    private String Addr;
    private String Port;

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
