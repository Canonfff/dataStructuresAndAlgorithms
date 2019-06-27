package com.canon.thread.class_one;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/22 17:00
 * @Description:测试多线程脏读
 */
public class TestOne {

    public static void main(String args[]) throws InterruptedException {
        PublicVar var = new PublicVar();
        ThreadA a = new ThreadA(var);
        a.start();

        Thread.sleep(200);

        var.getValue();
    }
}
// 公用类
class PublicVar {
    public String userName = "A";
    public String passWord = "AA";

    synchronized public void setValue(String userName, String passWord) {
        try {
            this.userName = userName;
            Thread.sleep(5000);
            this.passWord = passWord;

            System.out.println("setValue methon thread name ="
                    + Thread.currentThread().getName() + " userName = "
                    + userName + " passWord = " + passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println("getValue method thread name="
                + Thread.currentThread().getName() + " userName=" + userName
                + " passWord=" + passWord);
    }
}
class ThreadA extends Thread {

    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        publicVar.setValue("B","BB");
    }

}