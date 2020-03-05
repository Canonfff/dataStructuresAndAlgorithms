package com.canon.algorithms.sort;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: QuickSort2
 * @Author: Canon
 * @Description:快速排序2(不稳定)
 * @Date: 2020/3/5 16:33
 * @Version: 1.0
 */
public class QuickSort2 extends AbstractSort {

    public static void main(String[] args) {
        superMain(new QuickSort2());
    }

    /**
     * 快速排序逻辑
     * 定义一个基准值,一左一右两个指针;
     * 先移动右指针,如果比基准值小;则停止移动,将其值赋予左指针所在的角标
     * 再移动左指针,.如果比基准值大,则停止移动,将其赋值到右指针所在的角标
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        checkArray(arr);

        quickSort(arr, 0, arr.length);
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = getIndex(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    private int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high --;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= tmp) {
                low ++;
            }
            arr[high] = arr[low];
        }

        arr[low] = tmp;
        return low;
    }


}
