package com.canon.algorithms.sort;

/**
 * @ProjectName: dataStructuresAndAlgorithms
 * @Package: com.canon.algorithms.sort
 * @ClassName: HeapSort
 * @Author: Canon
 * @Description:堆排序(不稳定排序)
 * @Date: 2020/3/4 15:06
 * @Version: 1.0
 */
public class HeapSort extends AbstractSort {

    public static void main(String[] args) {
        superMain(new HeapSort());
    }

    /**
     * 堆排序的逻辑
     * 堆排序目前是我看的最久,也是理解的最久的一个排序;
     * 这个排序的逻辑,是先将构建一个大堆顶;说人话就是将第一次构建大堆顶的时候将元素大的数据移动到第一位;
     * 这个是必须处理完成的;交换的逻辑在第一次构建大堆顶的时候就可以遍历到所有的数据,毫无疑问,所有的数据都比较了一遍
     * 那么最大的元素就会移到第一位;
     * 然后将首位与末位的数据进行交换;将最大的元素移动到最后面
     * 然后剩下的元素再构建一次大堆顶;循环继续;直到所有的元素排序完成
     *
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        checkArray(arr);
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len --;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }

    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
