package com.canon.concurrent.worker;

import com.canon.concurrent.node.NodeContext;

/**
 * @Author Canon
 * @Date:Created in 14:07 2020/8/9
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class RequestWorker implements Runnable {

    private String name;

    public RequestWorker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // 1s 获取一次路径
        while (true) {
            System.out.println(name + " current uri is " + NodeContext.getUri());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
