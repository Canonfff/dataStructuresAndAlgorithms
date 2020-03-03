package com.canon.algorithms.sort;

import java.util.Arrays;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: MergeSort
 * @Author: Canon
 * @Description:归并排序
 * @Date: 2020/3/3 12:36
 * @Version: 1.0
 */
public class MergeSort extends AbstractSort {
    public static void main(String[] args) {
        superMain(new MergeSort());
    }

    /**
     * 归并排序的逻辑
     * 其实相对来说,归并排序的逻辑比希尔排序更加简单一些
     * 归并排序就是空间换时间
     * 将数组拆成最小单元,也就只有一个的情况下;
     * 将数组进行排序;然后将数组重新组合起来;
     * 也就是将数组打散再将数组进行重新组合
     * @param sourceArray
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        // 对 arr 进行拷贝，不改变参数内容
        checkArray(arr);
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }
}
