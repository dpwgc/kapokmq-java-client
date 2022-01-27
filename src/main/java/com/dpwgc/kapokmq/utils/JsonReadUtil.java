package com.dpwgc.kapokmq.utils;

import com.alibaba.fastjson.JSONArray;
import com.dpwgc.kapokmq.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Json数据解析
 */
public class JsonReadUtil {

    public static List<Node> getList(String json){
        List<Node> nodes = new ArrayList<>();
        try {
            //转换为Map对象
            nodes = JSONArray.parseArray(json, Node.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return nodes;
    }

}
