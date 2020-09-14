package com.canon.java.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @PackageName: com.canon.java.thread.forkjoin
 * @Description:
 * @author: canon
 * @date: 2020/9/14 9:19
 * @Version: 1.0
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i] + "");
        }
        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        pool.invoke(task);
        System.out.println("main out put");
        // task.invoke();
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f", nums[i]);
            System.out.println();
        }
    }
}
