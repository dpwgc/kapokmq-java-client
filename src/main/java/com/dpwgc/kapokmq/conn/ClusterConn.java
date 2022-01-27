package com.dpwgc.kapokmq.conn;

import com.dpwgc.kapokmq.model.Node;
import com.dpwgc.kapokmq.utils.HttpUtil;
import com.dpwgc.kapokmq.utils.JsonReadUtil;

import java.util.List;

/**
 * 集群连接
 */
public class ClusterConn {

    /**
     * 获取集群中所有消息队列节点
     * @param url 注册中心接口链接
     * @param secretKey 安全访问密钥
     * @return List<Node>
     */
    public List<Node> GetNodes(String url,String secretKey){
        String res = HttpUtil.sendPost(url,secretKey);

        return JsonReadUtil.getList(res);
    }
}
