package com.canon.java.thread.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * @PackageName: com.canon.java.thread.forkjoin
 * @Description:
 * @author: canon
 * @date: 2020/9/14 9:02
 * @Version: 1.0
 */
public class SqrtTransform extends RecursiveAction {

    final int seqThreadhold = 1000;

    double[] data;

    int start, end;

    public SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public void compute() {
        if ((end - start) < seqThreadhold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            // 分治策略
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
}
