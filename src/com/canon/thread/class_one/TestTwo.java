package com.canon.thread.class_one;

import sun.security.provider.Sun;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/22 17:22
 * @Description:测试可重入锁
 */
public class TestTwo {
    public static void main(String[] args) {
        test02();
    }
    static void test01() {
        MyThread myThread = new MyThread();
        myThread.start();
    }
    static void test02() {
        Mythread2 mythread2 = new Mythread2();
        mythread2.start();
    }
}
class parent {
    public int i = 10;
    protected synchronized void operateIMainMethod() {
        try {
            i--;
            System.out.println("parent print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
class Sub extends parent {
    public synchronized void operateSubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Mythread2 extends Thread {
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateSubMethod();
    }
}

// -----------------------------------华丽的分割线-----------------------------------
class Service {
    public synchronized void service1() {
        System.out.println("service1");
        serivce2();
    }
    public synchronized void serivce2() {
        System.out.println("service2");
        service3();
    }
    public synchronized void service3() {
        System.out.println("service3");
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}
