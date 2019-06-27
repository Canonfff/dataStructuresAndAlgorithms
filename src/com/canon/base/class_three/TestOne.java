package com.canon.base.class_three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/13 14:52
 * @Description:
 */
public class TestOne {
    public static void main(String args[]) {
        List<String> strings = Collections.synchronizedList(new ArrayList<String>());
        List<String> lists = new CopyOnWriteArrayList<String>();
        List<List<String>> lists1 = Collections.singletonList(lists);
    }
}
