package com.canon.thread.class_three;

import com.canon.thread.factory.CustomFactory;
import com.canon.thread.factory.CustomRejectedExecutionHandler;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/25 16:11
 * @Description:
 */
public class TestOne {
    private static ExecutorService service = null;
    static {
        service = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        new ThreadPoolExecutor(5,
                5,
                0L,
                        TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new CustomFactory(),
                new CustomRejectedExecutionHandler());
    }


    public static void main(String[] args) {

    }
}

class WorkerThread extends Thread {
    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " end time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return this.command;
    }
}