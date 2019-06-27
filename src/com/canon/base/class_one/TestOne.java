package com.canon.base.class_one;

import com.canon.utils.RandomUtils;

import java.util.Arrays;

/**
 * 一个N的数组,获取第k大的值
 */
public class TestOne {
    private static final String BULE = "排序实现";
    private static final String ALGORITHMS = "算法实现";
    public static void main(String[] args){
        int[] array = RandomUtils.getRandomArray(10);
        System.out.println(Arrays.toString(array));
        System.out.println(getKData(array, 1));
    }

    /**
     * get the in array element by k value
     * @param arr
     * @param k
     * @return
     */
    static int getKData(int[] arr, int k){
        if (arr == null ){
            throw new IllegalArgumentException("this array is null");
        }
        if (arr.length < k){
            throw new IllegalArgumentException("the element is too big");
        }
        if (k <= 0){
            throw new IllegalArgumentException("the k value can not less than zero");
        }
        int kMax = 0;
        return getKData(arr, k, ALGORITHMS);
    }
    static int getKData(int[] arr, int k, String type){
        int kMax = 0;
        switch (type){
            case BULE :
                kMax = bule(arr, k);
                break;
            case ALGORITHMS :
                kMax = algorithms(arr,k);
                break;
            default:
                kMax = algorithms(arr, k);
                break;
        }
        return kMax;
    }

    /**
     * get k value by bule ways
     * @param arr
     * @param k
     * @return
     */
    static int bule(int[] arr,int k){
        sort(arr,arr.length);
        return arr[k-1];
    }

    /**
     * get k value by algorithms ways
     * @param arr
     * @param k
     * @return
     */
    static int algorithms(int[] arr,int k){
        int[] newArray = getNewArray(arr,k);
        for (int i = k; i < arr.length; i++){
            int num = arr[k];
            for (int j = 0; j < k; j++){
                if (num > newArray[j]){
                    int temp = num;
                    num = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray[k-1];
    }

    /**
     * get pre element in source Array and sort by desc
     * @param arr
     * @param end
     * @return
     */
    static int[] getNewArray(int[] arr,int end){
        int[] newArray = new int[arr.length];
        System.arraycopy(arr,0,newArray,0,end);
        sort(newArray,end);
        return newArray;
    }

    /**
     * array sort
     * @param arr
     */
    static void sort(int[] arr, int sortNum){
        for (int i=1;i<sortNum;i++){
            for (int j=0;j<sortNum-i;j++){
                if (arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
