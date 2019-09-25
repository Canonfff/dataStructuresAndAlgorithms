package com.canon.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Properties;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/8/9 09:42
 * @Description:
 */
public class TestOne {

    public static void main(String[] args) throws IOException {
        InputStream in= Properties.class.getResourceAsStream("/file/callbackBeanName.txt");
        // 包点类名下的。
        // 如果找不到带有该名称的资源，则返回 null
//        Properties p = new Properties();
//        p.load(in);
//        System.out.println(p);
        StringBuffer sb = new StringBuffer();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(",");
        }
        String facades = sb.toString();
        System.out.println(facades);
        String[] arr = facades.split(",");
        System.out.println(Arrays.toString(arr));
    }

}
