package com.canon.algorithms.sort;

import java.util.Arrays;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: RadixSort
 * @Author: Canon
 * @Description:基数排序
 * @Date: 2020/3/5 14:48
 * @Version: 1.0
 */
public class RadixSort extends AbstractSort {

    public static void main(String[] args) {
        superMain(new RadixSort());
    }

    /**
     * 基数排序逻辑
     * 首先是取出最大位数,然后对最大位数进行除10处理
     * 这里是为了看究竟是几位数;
     * 然后,按照位数进行循环
     * 然后按照个位数进行容器装载;
     * 再放入到容器中;最后对原数组进行赋值;这样就自动排完序
     * 这里首先是对个位数进行排序,然后对10位数进行排序,对千位数进行排序,以此类推
     * 这里使用了空间换时间的方式去处理排序问题
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        checkArray(arr);
        int maxValue = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int maxDigit = getNumLen(maxValue);

        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod ) / dev) + mod;
                counter[bucket] = arrAppend(counter[bucket], arr[j]);
            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }

        }
        return arr;
    }


    /**
     * 获取位数
     * @param num
     * @return
     */
    public int getNumLen(long num) {
        if (num == 0) {
            return 1;
        }
        int len = 0;
        for (long i = num; i != 0 ; i /= 10) {
            len ++;
        }
        return len;
    }

    private int[] arrAppend(int[] arr, int i) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = i;
        return arr;
    }
}
