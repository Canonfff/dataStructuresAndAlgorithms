package com.canon.base.class_three;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/19 10:49
 * @Description:
 */
public class TestThree {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aaa", null);
        map.put("bbb", "aaa");
        map.put("ccc", null);

        check : {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() == null) {
                    break check;
                }
            }
            System.out.println("没有问题");
        }
        System.out.println("有问题");
    }

    /**
     * 测试静态导包
     */
    private void demo01() {
        int num1 = 1, num2 = 2;
        int max = max(1,2);
    }
}
