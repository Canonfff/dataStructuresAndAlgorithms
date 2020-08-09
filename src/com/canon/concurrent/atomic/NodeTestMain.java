package com.canon.concurrent.atomic;

import com.canon.concurrent.contants.NodeContants;
import com.canon.concurrent.node.Node;
import com.canon.concurrent.node.NodeContext;
import com.canon.concurrent.worker.ChangeWorker;
import com.canon.concurrent.worker.RequestWorker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Canon
 * @Date:Created in 14:09 2020/8/9
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class NodeTestMain {

    public static void main(String[] args) {
        Map<String, Node> nodeMap = init();
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 切换上下文
        service.execute(new ChangeWorker("change1", nodeMap));
        service.execute(new ChangeWorker("change2", nodeMap));
        service.execute(new ChangeWorker("change3", nodeMap));

        // 获取请求路径
        ExecutorService service2 = Executors.newFixedThreadPool(2);
        service2.execute(new RequestWorker("request1"));
        service2.execute(new RequestWorker("request2"));
    }

    public static Map<String, Node> init() {
        ConcurrentHashMap<String, Node> map = new ConcurrentHashMap<>();
        long timeMillis = System.currentTimeMillis();
        map.put("localhost://master", new Node().setLastAcliveTime(timeMillis).setPoint(NodeContants.master).setUri("localhost://master"));
        map.put("localhost://slave", new Node().setLastAcliveTime(timeMillis).setPoint(NodeContants.slave).setUri("localhost://slave"));
        NodeContext.changeContext(map.get("localhost://master"));
        return map;
    }
}
