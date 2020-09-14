package com.canon.java.thread.class_one;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/25 09:43
 * @Description:
 */
public class TestThree {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Demo01 demo01 = new Demo01();
        demo01.start();
        Thread.sleep(1000);
        demo01.setIsrunning(false);
        System.out.println("已经被赋值为false");
        System.out.println("总共花去:" + (System.currentTimeMillis() - start) + "毫秒");
    }
}
class Demo01 extends Thread {
    private boolean isrunning = true;

    public boolean isIsrunning() {
        return isrunning;
    }

    public void setIsrunning(boolean isrunning) {
        this.isrunning = isrunning;
    }

    @Override
    public void run() {
        while (isrunning) {
            int i = 1 + 1;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程停止了");
    }
}
