package com.canon.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2020/1/2 15:26
 * @Description:java8新特性
 */
public class Java8NewCharacteristic {

    public static void main(String[] args) {
        lambdaExpression();
    }

    /**
     * 新特性1,接口默认方法体
     */
    public static void newInterface() {
        // 构造一个实现,可以不用实现具体方法
        Java8Interface java8Interface = new Java8Interface() {
            @Override
            public void out(String message) {
                out();
            }
        };
        java8Interface.out("what the fuck");
    }


    interface Java8Interface {

        void out(String message);

        default void out() {
            System.out.println("hello world!!!");
        }
    }


    /**
     * lambda表达式
     */
    public static void lambdaExpression() {
        // 这个ArrayList 是Arrays的内部类
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        // 传统方法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(names);

        // 使用lambda表达式
        // 初级版
        Collections.sort(names, (String o1, String o2) -> {
            return o1.compareTo(o2);
        });
        // 进阶版 返回可以省略
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        // 终极版 类型可以省略
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
    }

    /**
     * 新的关键字 ::
     */
    public static void newKeyWord() {
        String s = "123";

    }






}


