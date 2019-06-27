package com.canon.base.class_one;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/13 09:30
 * @Description:用于测试scan
 */
public class TestEleven {
    public static void main(String[] args) {
        TestEleven eleven = new TestEleven();
        eleven.demo01();
    }

    /**
     * scan 这个东西指的是一个标签
     */
    private void demo01() {
        int i = 0;
        // 可以是scan
        scan : {
            for (; i < 100; i++) {
                if (i == 10000) {
                    break scan;
                }
            }
            System.out.println(i);
        }
        System.out.println(i+10);
        // 也可以是a
        a : {
            for (; i < 100; i++) {
                if (i == 30) {
                    break a;
                }
            }
            System.out.println(i);
        }
        System.out.println(i+10);
    }
}
