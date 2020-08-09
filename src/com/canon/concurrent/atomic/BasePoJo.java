package com.canon.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author Canon
 * @Date:Created in 13:07 2020/8/8
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class BasePoJo implements Runnable {

    private AtomicBoolean flag = new AtomicBoolean(false);

    public AtomicBoolean getFlag() {
        return flag;
    }

    public void setFlag(AtomicBoolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

    }
}
