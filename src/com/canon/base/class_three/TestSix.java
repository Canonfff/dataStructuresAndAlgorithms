package com.canon.base.class_three;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/4/17 18:34
 * @Description:
 */
public class TestSix {
    public static void main(String[] args) {
        demo02();
    }
    public static void demo01() {
        List<Object> lists = new ArrayList<Object>();
        lists.add(new Object());
        lists.add(new Object());
        Object o1 = lists.get(0);
        Object o = new Object();
        lists.set(0,o);
        System.out.println(o + " ::: " + o1);
        System.out.println(lists);
    }
    public static void demo02() {
        List<Object> lists = new ArrayList<Object>();
        lists.add(new Object());
        lists.add(new Object());
        int index = 0;
        for (Object list : lists) {
            if (index ++ == 0) {
                System.out.println(list);
                list = new Object();
                System.out.println(list);
            }
        }
        System.out.println(lists);
    }
}
