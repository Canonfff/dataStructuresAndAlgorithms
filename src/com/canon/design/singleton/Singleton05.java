package com.canon.design.singleton;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 14:58
 * @Description:懒汉式,静态内部类
 */
public class Singleton05 {
    private static class SingletonHolder {

        private static final Singleton05 INSTANCE = new Singleton05();

    }
    private Singleton05() {}

    public static Singleton05 getInstance() {
        return SingletonHolder.INSTANCE;
    }


}
