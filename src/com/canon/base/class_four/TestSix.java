package com.canon.base.class_four;

import com.canon.utils.RandomUtils;

import java.util.Arrays;

/**
 * @Author Canon
 * @Date:Created in 22:32 2020/4/18
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class TestSix {


    static int binarySearch(int[] arr, int n) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            if (arr[mid] > n) {
                right = mid;
            }
            if (arr[mid] < n) {
                left = mid + 1;
            }
        }
        return -1;
    }


//    public static void main(String[] args) {
//        int[] ints = RandomUtils.randomArray(10, 20);
//        int n = ints[0];
//        System.out.println("排序前" + Arrays.toString(ints));
//        buleSort(ints);
//        System.out.println(n);
//        System.out.println("排序后" + Arrays.toString(ints));
//        System.out.println(binarySearch(ints, n));
//    }

    /**
     * 简单写一下冒泡吧
     * @param arr
     * @return
     */
    static int[] buleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println("1954974080".hashCode());


    }
}
