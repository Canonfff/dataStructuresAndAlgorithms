package com.canon.design.singleton;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/22 11:29
 * @Description:静态内部类的单例模式
 */
public class Singleton {
    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
