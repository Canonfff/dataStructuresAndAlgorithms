package com.canon.java.base.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.canon.java.base.java8
 * @Description:
 * @author: canon
 * @date: 2020/9/7 10:39
 * @Version: 1.0
 */
public class Java8Map {
    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();

        // merge方法是如果不存在这个键就直接存入,如果存在这个键,那么就使用方法引用比较
        maps.merge("a",1, (key1, key2) -> key1 + key2);
        maps.merge("a",10, Integer::sum);


        System.out.println(maps);
    }
}
