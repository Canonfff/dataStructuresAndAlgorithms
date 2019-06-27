package com.canon.design.factory.simple;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 15:54
 * @Description:简单工厂模式,使用反射机制进行限制
 */
public class SimpleFactory {

    /**
     * 通过反射机制获取实例
     * @param clazz
     * @return
     */
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
