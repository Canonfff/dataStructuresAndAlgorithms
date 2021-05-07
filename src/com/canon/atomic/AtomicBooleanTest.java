package com.canon.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName CasOne
 * @Description
 * @Author Canon
 * @Date 2021/3/4 15:45
 */
public class AtomicBooleanTest {

    private volatile int count;

    private AtomicBoolean acqiure = new AtomicBoolean(false);

    private final AtomicBoolean refreshed = new AtomicBoolean(false);

    public static void main(String[] args) {
        AtomicBooleanTest test = new AtomicBooleanTest();
//        test.refreshOnce();

        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    test.cas();
                }
            });
        }
        service.shutdown();
    }

    /**
     * 验证只加载一次
     */
    public void refreshOnce() {
        if (!refreshed.compareAndSet(false, true)) {
            throw new IllegalArgumentException("just call refresh once");
        }
    }

    public void cas() {
        boolean call = true;
        int times = 0;
        while (call) {
            if (acqiure.compareAndSet(false, true)) {
                System.out.println("update success, count[" + ++count + "]");
                acqiure.compareAndSet(true, false);
                break;
            }
            if (times>3) {
                System.out.println("update fail break");
                break;
            }
            times++;
        }
    }


}
