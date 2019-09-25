package com.canon.base.class_three;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/24 14:07
 * @Description:
 */
public class TestEight {
    public static void main(String[] args) {
        System.out.println(bookPrice(4.5, 3.6, 1.6));
    }

    /**
     * 怎么用代码逻辑去解决数学公式呢?
     * 首先,肯定是变量形式;
     * @return
     */
    static Map bookPrice(double var1, double var2, double var3) {
//        double x, y, z;
//        z - x = 4.5; 小刚
//        z - y = 3.6; 小强
//        y + x - z = 1.6; 书钱
        Map<String, Double> money = new HashMap<>(3);
        // x = y - m
        double m = var1 - var2;// 小强比小刚多了m元
        // y + y - m - z = 1.6
        // 2y - z = 2.5, z - y = 3.6
        double m2 = var3 + m;// 两个小强比书钱多了m2元
        double y = m2 + var2;
        double x = y - m;
        double z = y + var2;
        money.put("小刚", x);
        money.put("小强", y);
        money.put("书钱", z);
        return money;
    }
}
