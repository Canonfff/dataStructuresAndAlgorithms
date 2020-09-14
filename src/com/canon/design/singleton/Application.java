package com.canon.design.singleton;

import java.lang.reflect.Constructor;

/**
 * @PackageName: com.canon.design.singleton
 * @Description:
 * @author: canon
 * @date: 2020/9/4 10:33
 * @Version: 1.0
 */
public class Application {
    public static void main(String[] args) throws Exception {
        RejectRefSingleton instance = RejectRefSingleton.getInstance();
        Class<RejectRefSingleton> singletonClass = RejectRefSingleton.class;
        // RejectRefSingleton singleton = singletonClass.newInstance();
        Constructor<RejectRefSingleton> constructor = singletonClass.getConstructor(null);
        RejectRefSingleton singleton = constructor.newInstance();
    }
}
