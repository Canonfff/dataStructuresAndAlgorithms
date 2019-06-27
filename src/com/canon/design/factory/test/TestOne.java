package com.canon.design.factory.test;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 16:01
 * @Description:
 */
public class TestOne {

    private static int count = 8;

    public static void main(String[] args) {
        TestOne one = new TestOne();

        double calc = one.calc(3);
    }


    public double calc(double x) {
        if (count == 0) {
            System.out.println("总共摘了:" + x + "根香蕉");
            return x;
        }
        // 前一天剩下的
        double num = (x + 1) * 3 / 2;
        System.out.println("第" + count + "天吃了" + (num - x) + "根香蕉");
        count --;
        return calc(num);
    }
}
