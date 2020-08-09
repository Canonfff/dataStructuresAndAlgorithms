package com.canon.concurrent.node;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author Canon
 * @Date:Created in 14:01 2020/8/9
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class NodeContext {

    private volatile static Node currentNode;

    /**
     * 获取uri
     * @return
     */
    public static String getUri() {
        return currentNode.getUri();
    }

    public static String getPoint() {
        return currentNode.getPoint();
    }

    /**
     * 切换上下文
     * @param name
     * @param node
     */
    public static void changeContext(String name, Node node) {
        System.out.println(name + " change Context node : " + node.getPoint());
        changeContext(node);
        node.releaseLock();
    }

    public static void changeContext(Node node) {
        currentNode = node;
    }

}
