package com.canon.base.class_three;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/24 11:11
 * @Description:
 */
public class TestSeven {
    public static void main (String args[]) {
        ThreadLocal<Map> local = new ThreadLocal();
        Map<String, String> maps= new HashMap<String,String>();
        maps.put("wocao", "test");
        local.set(maps);
        System.out.println(local.get());
        ThreadLocal<String> thread = new ThreadLocal();
        thread.set("ceshi");
        System.out.println(thread.get());
    }
}
