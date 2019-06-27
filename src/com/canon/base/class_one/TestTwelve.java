package com.canon.base.class_one;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/13 10:10
 * @Description:
 */
public class TestTwelve {
    public static void main(String args[]) {
        TestTwelve twelve = new TestTwelve();
        // twelve.demo01();
        // twelve.demo02();
        // twelve.demo03(1);
        twelve.demo04();
    }

    private void demo01() {
        for (int i = 0;i <= 200; i++) {
            System.out.print(i + ":" +(char)i + "\t");
            if (i % 20 == 0) {
                System.out.println();
            }
            if ((char)i == ' '){
                System.err.println(i);
            }
        }
    }

    private void demo02() {
        String str = " abc def ghi";
        String trim = str.trim();
        System.out.println(trim);
    }

    private void demo03(Integer...arguments){
        // 其实这个东西就是一个数组吧
        Integer[] arr = arguments;
        if (arr == null) {
            throw new NullPointerException();
        }
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }

    /**
     * ^=       这个是什么鬼?
     */
    private void demo04() {
        int num = 1000;
        num ^= 5;
        System.out.println(num);
        num = 1000;
        num &= 5;
        System.out.println(num);
        num = 1000;
        num |= 5;
        System.out.println(num);
    }

}
