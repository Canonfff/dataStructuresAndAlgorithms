package com.canon.base.class_four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/9/27 14:28
 * @Description:
 */
public class TestTwo {
    /**
     * test jdk 1.8
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("1","a");

        List<String> lists = new ArrayList<String>();
        lists.add("wocao");
        lists.forEach(n -> System.out.println(n));

    }
}
