package com.canon.algorithms.sort;

import com.canon.utils.RandomUtils;

import java.util.Arrays;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: BubbleSort
 * @Author: Canon
 * @Description:冒泡排序(稳定排序)
 * @Date: 2020/3/2 11:08
 * @Version: 1.0
 */
public class BubbleSort extends AbstractSort {

    public static void main(String[] args) {
        superMain(new BubbleSort());
    }

    /**
     * 本质就是和旁边的元素做比较;互换
     * 这种比较的次数是固定的;
     * 假如数组长度是10
     * 那么最多比较的次数是!10(10的阶乘)
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        checkArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 冒泡排序的另外一种实现方式,只拿最后一个值做比较
     * 比较次数
     * 假如数组长度是10
     * 这种排序比较的次数是固定的
     * 这种每次都需要比较!10(10的阶乘)
     * @param arr
     * @return
     */
    public int[] sort2(int[] arr) {
        checkArray(arr);
        for (int i = arr.length; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = arr[temp];
                }
            }
        }
        return arr;
    }



}
