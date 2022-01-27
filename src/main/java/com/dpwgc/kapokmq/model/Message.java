package com.dpwgc.kapokmq.model;

// Message 消费者接收的消息模板
public class Message {

    private String MessageCode;
    private String MessageData;
    private String Topic;
    private long CreateTime;
    private long DelayTime;
    private long ConsumedTime;
    private int Status;

    public void setDelayTime(long delayTime) {
        DelayTime = delayTime;
    }

    public void setMessageData(String messageData) {
        MessageData = messageData;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public void setConsumedTime(long consumedTime) {
        ConsumedTime = consumedTime;
    }

    public void setMessageCode(String messageCode) {
        MessageCode = messageCode;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public long getDelayTime() {
        return DelayTime;
    }

    public String getMessageData() {
        return MessageData;
    }

    public int getStatus() {
        return Status;
    }

    public long getConsumedTime() {
        return ConsumedTime;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public String getMessageCode() {
        return MessageCode;
    }

    public String getTopic() {
        return Topic;
    }

}
