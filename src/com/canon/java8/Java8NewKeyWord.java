package com.canon.java8;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @PackageName: com.canon.java8
 * @Description: java特性新关键字 ::
 * @author: canon
 * @date: 2020/5/27 17:56
 * @Version: 1.0
 */
public class Java8NewKeyWord {
    /**
     * 前言,java8提供了一种新的关键字, :: 这种是方法引用;可以引用构造器,静态方法,普通方法,特定类的方法
     */

    public static void main(String[] args) {
        // 构造器引用
        Supplier<Java8NewKeyWord> word = Java8NewKeyWord :: new;
        Java8NewKeyWord newKeyWord = word.get();
        newKeyWord.normalMethod();


    }


    class TestClass {


    }
    public static void staticMethod() {
        System.out.println("staticMethod");
    }

    public void normalMethod() {
        System.out.println("normalMethod");
    }
}
