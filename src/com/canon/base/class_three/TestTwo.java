package com.canon.base.class_three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/14 11:14
 * @Description:
 */
public class TestTwo {
    public static void main(String args[]) {
        String[] arr = {"1","2","3","4","5"};
        String[] dest = new String[4];
        // 比如我要移除第5个元素
        int numMoved = 5 - 4 - 1;
        // System.arraycopy(arr,5,arr,4,numMoved);

        // System.out.println(Arrays.toString(arr));
        TestTwo testTwo = new TestTwo();
//        testTwo.demo01();
        testTwo.demo03();
    }

    private void demo01() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            list.add("" + i);
        }
        list.remove(4);
    }
    private void demo02() {
        String[] arr = {"1","2","3","4","5"};
        String[] brr = {"1","2","3"};
        System.arraycopy(brr,0,arr,arr.length,brr.length);
        System.arraycopy(brr,0,arr,arr.length,brr.length);
        System.out.println(Arrays.toString(arr));
    }
    private void demo03() {
        List<String> list = new ArrayList<String>();
        List<String> removes = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            list.add("" + i);
        }
        for (int j = 1; j <= 5; j++) {
            removes.add("" + j);
        }
        list.removeAll(removes);
        System.out.println(list);
    }
}
