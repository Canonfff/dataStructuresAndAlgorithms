package com.canon.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicIntegerTest
 * @Description
 * @Author Canon
 * @Date 2021/3/4 16:36
 */
public class AtomicIntegerTest {

    private AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        AtomicIntegerTest test = new AtomicIntegerTest();
        System.out.println("init get atomicInteger [" + test.atomicInteger.get() + "]");
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    test.incr();
                }
            });
        }
        service.shutdown();
    }

    public void incr() {
        System.out.println("get atomicInteger [" + atomicInteger.incrementAndGet() + "]");
        System.out.println("get atomicInteger [" + atomicInteger.getAndIncrement() + "]");
    }

    public void decr() {
        System.out.println("get atomicInteger [" + atomicInteger.decrementAndGet() + "]");
        System.out.println("get atomicInteger [" + atomicInteger.getAndDecrement() + "]");
    }

}
