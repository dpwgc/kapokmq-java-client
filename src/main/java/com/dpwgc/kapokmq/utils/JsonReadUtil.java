package com.dpwgc.kapokmq.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dpwgc.kapokmq.model.Message;
import com.dpwgc.kapokmq.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Json数据解析
 */
public class JsonReadUtil {

    public static List<Node> getNodes(String json){
        List<Node> nodes = new ArrayList<>();
        try {
            nodes = JSONArray.parseArray(json, Node.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return nodes;
    }

    public static Message getMessage(String json){
        Message message = new Message();
        try {
            message = JSONObject.parseObject(json, Message.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
