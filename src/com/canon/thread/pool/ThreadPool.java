package com.canon.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @PackageName: com.canon.thread.pool
 * @Description: 线程池
 * @author: canon
 * @date: 2020/5/25 17:37
 * @Version: 1.0
 */
public class ThreadPool {

    public static void main(String[] args) {
        shedule();
    }

    /**
     * java定时任务执行
     */
    static void shedule() {
        AtomicInteger i = new AtomicInteger(1);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(()-> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行了线程池" + (i.incrementAndGet()));
        }, 1000, 2000, TimeUnit.MILLISECONDS);
    }
}
