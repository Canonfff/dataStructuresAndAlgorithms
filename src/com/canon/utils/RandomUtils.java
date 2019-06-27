package com.canon.utils;

import java.util.Random;

/**
 * 获取随机数组,随机数...
 */
public abstract class RandomUtils {
    public static int[] getRandomArray(int n){
        if (0>=n)
            throw new RuntimeException("请按套路出牌");
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0;i<n;i++){
            array[i] = random.nextInt();
        }
        return array;
    }
}
