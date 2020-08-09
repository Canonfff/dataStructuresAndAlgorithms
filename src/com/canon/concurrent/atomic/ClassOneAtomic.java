package com.canon.concurrent.atomic;

import com.canon.concurrent.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Canon
 * @Date:Created in 13:05 2020/8/8
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class ClassOneAtomic {
    public static void main(String[] args) {
        BasePoJo poJo = new BasePoJo();
        System.out.println(poJo.getFlag());
    }

    public static List<Node> init() {
        Node master = new Node();
        master.setPoint("Master");
        master.setUri("localhost://master");
        Node slave = new Node();
        slave.setPoint("Slave");
        slave.setUri("localhost://slave");
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(master);
        nodes.add(slave);
        return nodes;
    }
}
