package com.canon.base.class_four;

/**
 * @PackageName: com.canon.base.class_four
 * @Description:
 * @author: canon
 * @date: 2020/9/4 10:44
 * @Version: 1.0
 */
public class TestNine {
    public static void main(String[] args) {
        calc();
        calc2();
    }

    static long calc() {
        long s = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long e = System.currentTimeMillis();
        System.out.println("calc use " + (e - s));
        return sum;
    }
    static long calc2() {
        long s = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long e = System.currentTimeMillis();
        System.out.println("calc2 use " + (e - s));
        return sum;
    }
}
