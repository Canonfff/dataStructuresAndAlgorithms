package com.canon.base.class_three;

import java.util.Arrays;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/4/3 17:41
 * @Description:
 */
public class TestFour {
    /**
     * 数据去重
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 重复的特征是相等,利用这个相等
        int length = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] - nums[i + 1] == 0) {
                // 证明这两数字相同同
                length --;
                i ++;
            } else {
                System.arraycopy(nums,i + 1, nums, i, nums.length - i - 1);
            }
        }
        return length;
    }

    /**
     * 数据去除指定元素 TODO
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] == val) {
                nums[j] = nums[i + 1];
            } else {
                j ++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {0,0,1,1,1,1};
        int length = nums.length;
        int val = 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                length --;
                if (nums.length-1 == i) {

                }
                System.arraycopy(nums,i + 1, nums, i,nums.length);
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(j);
        System.out.println(length);
    }
}
