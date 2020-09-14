package com.canon.design.singleton;

/**
 * @PackageName: com.canon.design.singleton
 * @Description:单例模式抵御反射
 * @author: canon
 * @date: 2020/9/4 10:27
 * @Version: 1.0
 */
public class RejectRefSingleton {

    private static final RejectRefSingleton INSTANCE = new RejectRefSingleton();

    private static boolean init = false;

    private RejectRefSingleton() {
        if (init) {
            throw new AssertionError();
        }
    }

    public static RejectRefSingleton getInstance() {
        return INSTANCE;
    }
}
