package com.canon.java.base.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * @PackageName: com.canon.java.base.java8
 * @Description:java8一种新的迭代方法,可以支持并行/并发编程
 * @author: canon
 * @date: 2020/9/14 10:27
 * @Version: 1.0
 */
public class SpliteratorTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("1", "2", "3", "4");

        Spliterator<String> spliterator = list.spliterator();
        // 迭代
        while (spliterator.tryAdvance(System.out::println)) {

        }
        // 第二种迭代
        spliterator.forEachRemaining(System.out::println);
    }
}
