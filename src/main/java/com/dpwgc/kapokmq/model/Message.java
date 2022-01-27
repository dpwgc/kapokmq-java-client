package com.dpwgc.kapokmq.model;

// Message 消费者接收的消息模板
public class Message {

    private String MessageCode; //消息标识码
    private String MessageData; //消息主体（一般为json字符串）
    private String Topic;       //消息所属主题
    private long CreateTime;    //消息创建时间
    private long DelayTime;     //消息延时推送的时间（单位：秒）
    private long ConsumedTime;  //消息确认消费时间
    private int Status;         //消息状态（-1：未消费，0：消费失败/未消费的延时消息，1：已消费）

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
