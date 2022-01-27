package com.dpwgc.kapokmq.model;

// SendMessage 生产者发送的消息模板
public class SendMessage {

    private String MessageData; //消息主体
    private long DelayTime;     //消息延时推送的时间（单位：秒）

    public void setMessageData(String messageData) {
        MessageData = messageData;
    }

    public void setDelayTime(long delayTime) {
        DelayTime = delayTime;
    }

    public String getMessageData() {
        return MessageData;
    }

    public long getDelayTime() {
        return DelayTime;
    }
}
