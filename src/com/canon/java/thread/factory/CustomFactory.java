package com.canon.java.thread.factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 09:40
 * @Description:实现线程工厂,定制线程属性
 */
public class CustomFactory implements ThreadFactory {


    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePerfix;
    private final ThreadGroup group;

    public CustomFactory() {
        SecurityManager manager = System.getSecurityManager();
        // 线程管理对象
        group = (manager != null) ? manager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        // 自定义线程名称
        namePerfix = "custom-pool" + POOL_NUMBER.getAndIncrement() + "-thread-";
    }



    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, namePerfix + threadNumber.getAndIncrement(), 0);
        // 是否守护线程?
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        // 线程优先级
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
