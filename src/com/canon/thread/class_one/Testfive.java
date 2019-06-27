package com.canon.thread.class_one;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/25 10:35
 * @Description:
 */
public class Testfive {
    public static void main(String[] args) {
        try {
            Object lock = new Object();

            TestfiveA a = new TestfiveA(lock);
            a.start();

            Thread.sleep(50);

            TestfiveB b = new TestfiveB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class TestfiveA extends Thread {
    private Object lock;
    public TestfiveA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin "
                            + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end  "
                            + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class TestfiveB extends Thread {
    private Object lock;
    public TestfiveB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        lock.notify();
                        System.out.println("已经发出通知!");
                    }
                    System.out.println("已经添加了:" + (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            }

        } catch (Exception e) {

        }
    }
}
class MyList {
    private static List<String> list = new ArrayList<String>();

    public static void add() {
        list.add("anyThing..");
    }
    public static int size() {
        return list.size();
    }
}