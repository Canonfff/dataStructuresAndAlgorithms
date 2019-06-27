package com.canon.design.memento;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/4/17 15:13
 * @Description:存储备忘录的类
 */
public abstract class Storage {

    private static ConcurrentHashMap<String, Memento> map = new ConcurrentHashMap<String, Memento>();

    public static String record(Original original) {
        Original o = original;
        String key = UUID.randomUUID().toString();
        Memento memento = map.putIfAbsent(key, Memento.getInstance(o));
        if (memento != null) {
            record(original);
        }
        return key;
    }
    public static Original reSet(String key) {
        Memento memento = map.get(key);
        if (memento != null) {
            return memento.getOriginal();
        }
        return null;
    }
}
