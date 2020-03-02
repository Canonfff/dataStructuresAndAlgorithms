package com.canon.algorithms.sort;

import com.canon.utils.RandomUtils;

import java.util.Arrays;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: InsertionSort
 * @Author: Canon
 * @Description:插入排序(稳定排序)
 * @Date: 2020/3/2 11:42
 * @Version: 1.0
 */
public class InsertionSort extends AbstractSort {
    public static void main(String[] args) {
        superMain(new InsertionSort());
    }

    /**
     * 算法逻辑,
     * 其实就是将选择出来的数字,与前一位比较,如果前面的值大于选择值,那么则将后面的数据移位到前面
     * 直到前面的值小于后面的值
     * 这种做法其实就是将数组从小到大排序;每次比较的次数只有一次;
     * 假如数组长度是10,那么最少比较10次;
     * 最多比较!10(10的阶乘)
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        checkArray(arr);
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j-1] > temp) {
                    arr[j] = arr[j-1];
                } else {
                    arr[j] = temp;
                    break;
                }
            }
        }
        return arr;
    }
}
