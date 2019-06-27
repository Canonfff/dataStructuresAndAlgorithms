package com.canon.base.class_one;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2018/12/27 18:09
 * @Description:
 */
public class TestNine {
    public static void main(String args[]) {
        List<Long> lists = init();

        for (final Long list : lists) {

        }

    }
    static List<Long> init() {
        List<Long> lists = new ArrayList<Long>();
        lists.add(1L);
        lists.add(2L);
        lists.add(3L);
        lists.add(4L);
        lists.add(5L);
        lists.add(6L);
        lists.add(7L);
        lists.add(8L);
        lists.add(9L);
        lists.add(10L);
        return lists;
    }
}
