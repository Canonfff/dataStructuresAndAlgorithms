package com.canon.base.class_three;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/6/24 14:07
 * @Description:
 */
public class TestEight {
    public static void main(String[] args) {
        try {
            FileInputStream fi =new FileInputStream("error path");
            System.out.println(1);
        } catch (FileNotFoundException e) {
            System.out.println(2);
        }finally {
            System.out.println(3);
        }
    }
}
