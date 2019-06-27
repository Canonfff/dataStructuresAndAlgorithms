package com.canon.design.singleton;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 14:51
 * @Description:懒汉式,双重检验锁
 */
public class Singleton04 {
    private static Singleton04 instance;

    private Singleton04() {

    }

    public static Singleton04 getInstance() {
        if (instance == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }
}
