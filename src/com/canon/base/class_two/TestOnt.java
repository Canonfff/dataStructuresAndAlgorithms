package com.canon.base.class_two;

/**
 * @Auther: canon
 * @Date: 2018/10/31 11:46
 * @Description:
 */
public class TestOnt {

    public static void main(String[] args) {
        System.out.println(get(5));
    }
    static int get(int i) {
        if (i == 1) {
            return 1;
        }
        return i*get(i-1);
    }

}
