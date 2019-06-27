package com.canon.base.class_one;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/12 09:59
 * @Description:
 */
public class TestTen {

    public static void main(String args[]) throws ClassNotFoundException {
//        System.out.println(Class.forName("TestTen", true, new TestTen().getClass().getClassLoader()));
//        Properties properties = System.getProperties();
//        System.out.println(properties);
        TestTen ten = new TestTen();
//        ten.test01();
        // ten.test02();
        // System.out.println(new char[1]);

//        int num = 1;
//        num <<= 8;
//        String s = Integer.toBinaryString(num);
//        System.out.println(num);
//        System.out.println(s);
        String str = null;
        System.out.println(str.length());
    }

    private void test01() throws ClassNotFoundException {
        System.err.println(this.getClass());
        System.err.println(this.getClass().getClassLoader().loadClass(this.getClass().getName()));
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        runtime.gc();
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.maxMemory());
        runtime.exit(5000);

    }

    private void test02() {
        List<String> java = Collections.<String>singletonList("java");
        Set<String> python = Collections.<String>singleton("python");
        System.out.println(java);
    }


    /**
     * 为什么这么写?
     * 其实这里分为了两步走
     * 第一,将字符串分为了两个部分(以第一个需要替换位置的为分割线)
     * 第二,定义一个容器去接收不需要替换的部分,后面的部分逐个判断
     *
     * @param oldChar
     * @param newChar
     * @return
     */
    public String replace(char oldChar, char newChar) {
        // TODO 第一行我强行加上去的;避免报错
        char[] value = new char[0];
        if (oldChar != newChar) {
            int len = value.length;
            int i = -1;
            char[] val = value; /* avoid getfield opcode */

            // oldChar需要替换的老的字符
            while (++i < len) {
                // 第一个需要替换的字符的位置
                if (val[i] == oldChar) {
                    break;
                }
            }
            if (i < len) {
                // 先准备一个容器,存储0~第一个需要替换的字符的位置
                char buf[] = new char[len];
                for (int j = 0; j < i; j++) {
                    buf[j] = val[j];
                }
                // 后续再去进行判断是否要继续替换
                while (i < len) {
                    char c = val[i];
                    buf[i] = (c == oldChar) ? newChar : c;
                    i++;
                }
                // return new String(buf, true);
                return null;
            }
        }
        return null;
        // return this;
    }
}
