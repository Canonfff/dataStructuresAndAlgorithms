package com.canon.algorithms.sort;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: CountingSort
 * @Author: Canon
 * @Description:计数排序
 * @Date: 2020/3/5 12:46
 * @Version: 1.0
 */
public class CountingSort extends AbstractSort {

    public static void main(String[] args) {
        superMain(new CountingSort());
    }

    /**
     * 计数排序逻辑
     * 首先,这种排序方法有局限性,只能用于一定条件下的整数排序
     * 这种其实就是将元素作为新数组的下标,新数组的元素就是该元素出现的次数
     * 然后遍历新数据,根据出现的次数以及下标来对原数组进行赋值
     * 讲真,这种排序方式很辣鸡,但是思路很有意思
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        checkArray(arr);
        // arr = new int[] {-1, -3, -5, 2, 1};
        int maxValue = getMaxValue(arr);

        return countingSort(arr, maxValue);
    }

    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;

        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex ++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
