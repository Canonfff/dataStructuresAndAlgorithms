package com.canon.thread.class_one;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/25 09:59
 * @Description:volatile关键字是不是能保证变量的原子性操作
 */
public class TestFour {
    public static void main(String[] args) {
        TestFour01 arr = null;
        for (int i = 0; i < 100; i++) {
            new TestFour01().start();
        }

        /*TestFour01[] mythreadArray = new TestFour01[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new TestFour01();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }*/

    }
}
class TestFour01 extends Thread {
    private static int count;
    @Override
    public void run() {
        addCount();
    }
    private void addCount() {
        for (int i = 0; i < 100; i++) {
            count = i;
        }
        final int num = count;
        if (num != 99) {
            System.err.println("艹,你说的是对的 num = " + num);
        }
        System.out.println("count = " + num);
    }
}
