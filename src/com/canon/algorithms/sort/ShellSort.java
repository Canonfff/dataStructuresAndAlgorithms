package com.canon.algorithms.sort;

import java.util.Arrays;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: ShellSort
 * @Author: Canon
 * @Description:希尔排序(不稳定排序)
 * @Date: 2020/3/2 14:31
 * @Version: 1.0
 */
public class ShellSort extends AbstractSort {

    public static void main(String[] args) {
        superMain(new ShellSort());
    }

    /**
     * 希尔排序逻辑
     *
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] sourceArray) {
        checkArray(sourceArray);
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        return arr;
    }
}
