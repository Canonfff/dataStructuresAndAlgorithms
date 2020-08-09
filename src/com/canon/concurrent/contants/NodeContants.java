package com.canon.concurrent.contants;

/**
 * @Author Canon
 * @Date:Created in 14:53 2020/8/9
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public interface NodeContants {

    // 判定切换上下文时间
    long changeTime = 5000;


    // 节点名称 master
    String master = "master";
    // 节点名称 slave
    String slave = "slave";
}
