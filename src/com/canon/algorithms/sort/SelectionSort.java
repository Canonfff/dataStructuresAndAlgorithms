package com.canon.algorithms.sort;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: SelectionSort
 * @Author: Canon
 * @Description:选择排序(不稳定排序)
 * @Date: 2020/3/2 14:08
 * @Version: 1.0
 */
public class SelectionSort extends AbstractSort {

    public static void main(String[] args) {
        superMain(new SelectionSort());
    }

    @Override
    public int[] sort(int[] arr) {
        checkArray(arr);
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (i != min) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
