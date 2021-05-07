package com.canon.leecode;

import java.util.Objects;

/**
 * @ClassName CaseOne
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @Author Canon
 * @Date 2021/4/1 16:21
 */
public class CaseOne {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1,4,6,2,3};
        System.out.println(fn(arr));
    }

    static int fn(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            throw new IllegalArgumentException("arrays can not be null or empty");
        }

        int num = arr[0];

        for (int i = 1; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }
}
