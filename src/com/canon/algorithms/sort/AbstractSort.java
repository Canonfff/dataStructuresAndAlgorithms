package com.canon.algorithms.sort;

import com.canon.utils.RandomUtils;

import java.util.Arrays;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: AbstractSort
 * @Author: Canon
 * @Description:
 * @Date: 2020/3/2 11:44
 * @Version: 1.0
 */
public abstract class AbstractSort {
    public static void superMain(AbstractSort sort) {
        int[] array = RandomUtils.getRandomArray(10, 20);
        System.out.println("排序前" + Arrays.toString(array));
        System.out.println("排序后" + Arrays.toString(sort.sort(array)));
    }

    public abstract int[] sort(int[] arr);

    protected void checkArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("the param is illegal");
        }
    }
}
