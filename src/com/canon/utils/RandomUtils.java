package com.canon.utils;

import java.util.Random;

/**
 * 获取随机数组,随机数...
 */
public abstract class RandomUtils {
    public static int[] getRandomArray(int n){
        return randomArray(n, Integer.MAX_VALUE);
    }

    public static int[] getRandomArray(int n, int defaultRange) {
        return randomArray(n, defaultRange);
    }

    public static int[] randomArray(int n, int range) {
        if (0>=n)
            throw new RuntimeException("请按套路出牌");
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++){
            array[i] = random.nextInt(range);
        }
        return array;
    }
}
