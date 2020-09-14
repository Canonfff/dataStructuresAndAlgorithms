package com.canon.java.base.string;

import java.util.StringTokenizer;

/**
 * @PackageName: com.canon.java.base.string
 * @Description:
 * @author: canon
 * @date: 2020/9/11 14:05
 * @Version: 1.0
 */
public class StringTokenizerTest {

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("zhanzifan", "z");
        System.out.println(tokenizer.nextToken());
        System.out.println(tokenizer.nextToken());

    }
}
