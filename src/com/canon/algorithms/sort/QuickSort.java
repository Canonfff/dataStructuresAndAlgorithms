package com.canon.algorithms.sort;

import java.util.Arrays;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: QuickSort
 * @Author: Canon
 * @Description:快速排序
 * @Date: 2020/3/3 14:16
 * @Version: 1.0
 */
public class QuickSort extends AbstractSort {
    public static void main(String[] args) {
        superMain(new QuickSort());
    }

    /**
     * 快速排序的逻辑
     * 首先是找一个切入点(基准值)
     * 这个基准值选择的对象是数组的第一个元素,
     * 比基准大都移到右边,
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
         arr = new int[] {18, 10, 4, 18, 19, 12, 12, 0, 5, 6};
        checkArray(arr);
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        System.out.println(Arrays.toString(arr));
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
