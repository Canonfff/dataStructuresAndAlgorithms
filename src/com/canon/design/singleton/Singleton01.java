package com.canon.design.singleton;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 14:37
 * @Description:饿汉式(线程安全)
 */
public class Singleton01 {
    private static Singleton01 instance = new Singleton01();
    private Singleton01() {}
    public static Singleton01 getInstance() {
        return instance;
    }
}
