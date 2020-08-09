package com.canon.concurrent.worker;

import com.canon.concurrent.contants.NodeContants;
import com.canon.concurrent.node.Node;
import com.canon.concurrent.node.NodeContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Canon
 * @Date:Created in 14:07 2020/8/9
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class ChangeWorker implements Runnable {

    private String name;

    // uri
    private Map<String, Node> nodes = new ConcurrentHashMap<String, Node>();

    // point
    private Map<String, Node> points = new ConcurrentHashMap<String, Node>();


    private List<String> uris = new ArrayList<String>();
    private List<String> results = new ArrayList<String>();

    {
        uris.add("localhost://master");
        uris.add("localhost://slave");

        results.add("success");
        results.add("fail");
    }

    public ChangeWorker(String name, Map<String, Node> map) {
        this.name = name;
        nodes.putAll(map);
        nodes.entrySet().forEach(e -> points.put(e.getValue().getPoint(), e.getValue()));
    }

    @Override
    public void run() {
        // 2s请求一次, 10s改变一次返回结果, 超过5s切换上下文
        long count = 0;
        while (true) {
            Random rand = new Random();
            String uri = uris.get(rand.nextInt(uris.size()));
            long timeMillis = System.currentTimeMillis();
            Node node = nodes.get(uri);

            // 提高失败概率
            if (rand.nextInt(9) % 5 != 0) {
                // 切换上下文
                node.setAclive(false);
                System.err.println(name + " 请求失败, uri is " + uri + " lastAcliveTime is " + node.getLastAcliveTime());
                int update = 0;
                while (NodeContants.master.equals(node.getPoint())
                        && NodeContants.master.equals(NodeContext.getPoint())
                        && NodeContants.changeTime < (timeMillis - node.getLastAcliveTime())) {
                    Node slave = points.get(NodeContants.slave);
                    System.out.println(name + " current point " + NodeContext.getPoint());
                    // cas
                    if (NodeContants.master.equals(NodeContext.getPoint()) && slave.acqiure()) {
                        NodeContext.changeContext(name, slave);
                    }
                    update++;
                    if (update > 3) {
                        System.out.println(name + "update Node Context fail...");
                        break;
                    }
                }
            } else {
                System.out.println(name + " 请求成功, uri is " + uri + " currentTime is " + timeMillis);
                node.setAclive(true);
                node.setLastAcliveTime(timeMillis);
                // slave节点不切换
                int update = 0;
                while (NodeContants.slave.equals(NodeContext.getPoint()) && !NodeContants.slave.equals(node.getPoint())) {
                    System.out.println(name + " current point " + NodeContext.getPoint());
                    if (node.acqiure()) {
                        NodeContext.changeContext(name, node);
                    }
                    update++;
                    if (update > 3) {
                        System.out.println(name + " update Node Context fail...");
                        break;
                    }
                }

            }
            count++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
