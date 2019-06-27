package com.canon.design.singleton;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 14:44
 * @Description:懒汉式(线程不安全)
 */
public class Singleton02 {

    private static Singleton02 instance;

    private Singleton02() {

    }
    public static Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }
}
