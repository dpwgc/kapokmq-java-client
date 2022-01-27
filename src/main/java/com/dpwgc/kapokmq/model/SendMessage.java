package com.dpwgc.kapokmq.model;

// SendMessage 生产者发送的消息模板
public class SendMessage {

    private String MessageData;
    private long DelayTime;

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
