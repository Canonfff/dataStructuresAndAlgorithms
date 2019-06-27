package com.canon.base.class_three;

import com.canon.design.memento.Original;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/4/9 16:08
 * @Description:
 */
public class TestFive {
    public static void main(String[] args) {
        Original original = new Original("18","你是猪吗?");
        System.out.println("修改前:"+original);
        String record = original.record();
        original.setName("你真的是猪");
        System.out.println("修改后:" + original);
        original.reSet(record);
        System.out.println("重置后:" + original);
    }
}
