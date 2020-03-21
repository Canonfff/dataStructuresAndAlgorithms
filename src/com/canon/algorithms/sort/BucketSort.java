package com.canon.algorithms.sort;

import java.util.Arrays;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: BucketSort
 * @Author: Canon
 * @Description:
 * @Date: 2020/3/5 14:05
 * @Version: 1.0
 */
public class BucketSort extends AbstractSort {
    public static void main(String[] args) {
        superMain(new BucketSort());
    }

    /**
     * 桶排序逻辑
     * 其实就是用一个二维数组作为桶;
     * 将原数组分到二维数组里面,然后遍历二维数组,对数组进行排序
     * 然后将对原数组进行赋值
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        checkArray(arr);

        int bucketSize = 5;

        int maxValue = arr[0];
        int minValue = arr[0];

        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
            if (value < minValue) {
                minValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        InsertionSort insertionSort = new InsertionSort();
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }

            bucket = insertionSort.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex ++] = value;
            }
        }
        return arr;
    }

    private int[] arrAppend(int[] bucket, int i) {
        bucket = Arrays.copyOf(bucket, bucket.length + 1);
        bucket[bucket.length - 1] = i;
        return bucket;
    }
}
