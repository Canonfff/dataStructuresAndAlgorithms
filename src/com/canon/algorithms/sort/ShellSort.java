package com.canon.algorithms.sort;

import com.canon.utils.RandomUtils;

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
        // System.out.println((int) Math.floor(4 / 3));
        // superMain(new ShellSort());
        ShellSort shellSort = new ShellSort();
        int[] array = RandomUtils.getRandomArray(10, 20);
        System.out.println("排序前" + Arrays.toString(array));
        System.out.println("排序后" + Arrays.toString(shellSort.sort(array)));
        System.out.println("排序前" + Arrays.toString(array));
        System.out.println("排序后2" + Arrays.toString(shellSort.sort2(array)));
    }

    /**
     * 希尔排序逻辑
     * 希尔排序是先使用逻辑分区;
     * 将数据切成以增量选择子分区成员;
     * 然后对子分区内的数字进行排序;
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

        /*
            设立一个基准值,
            使用temp = 基准值
            每次的while循环交换都是以步长(增量)为单位的交换
            这里的思想和插入排序的思想的一致
            比较值大小;记录下标,然后进行元素位移

            j + gap 是最后一次位移的值;根据这个值可知;这个值的元素有可能被移动过;那么就应该将基准值放置到这里
            其实,这是一种假设思想;
            首先不信任任何一种情况,先将要(可能进行)移动的值记录下来,这个值就是tmp
            然后,进行元素位移,如果有发生位移,那么最后的移动的角标可以得到;那么只需要将基准值放置到这个位置就可以;

            类似于,拿一个基准值,与分区内的值(向前)进行比较;如果比基准值大,那么进行值交换;直到角标超出范围,
            或者比较的值小于基准值;这种做法其实就是对增量内的内容进行比较;
         */
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

    /**
     * 这里和插入排序不像
     * @param arr
     * @return
     */
    public int[] sort2(int[] arr) {
        int gap = 1;
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - gap;
            while (j >= 0 && arr[j] > tmp) {
                arr[j + gap] = arr[j];
                j -= gap;
            }
            arr[j + gap] = tmp;
        }
        return arr;
    }
}
