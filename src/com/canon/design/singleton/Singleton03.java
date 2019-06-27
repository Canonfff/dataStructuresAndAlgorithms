package com.canon.design.singleton;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 14:46
 * @Description:懒汉式(加锁,线程安全)
 */
public class Singleton03 {

    private static Singleton03 instance;

    private Singleton03() {}

    /**
     * synchronized 偏重量级锁;这样会有一些性能问题
     * @return
     */
    public synchronized Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}
