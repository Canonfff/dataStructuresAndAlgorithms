package com.canon.base.class_four;

/**
 * @Author Canon
 * @Date:Created in 14:42 2020/3/21
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class TestThree {

    /**
     * 面试题
     * 1
     * 11
     * 21
     * 1211
     * 111221
     * @param args
     */
    public static void main(String[] args) {
        readStr(String.valueOf("1"), 8);
    }


    static String readStr(String str, int index) {
        System.out.println(str);
        if (str == null) {
            throw new IllegalArgumentException("不能输入null");
        }
        if (1 >= index) {
            return str;
        }

        char[] chars = str.toCharArray();

        int point = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (; j < chars.length; j++) {
            if (chars[point] != chars[j]) {
                change(sb, j - point, str.charAt(point));
                point = j;
            }
        }
        if (j != point) {
            change(sb, j - point, str.charAt(point));
        }
        return readStr(sb.toString(), -- index);
    }

    static void change(StringBuilder sb, int temp, char c) {
        sb.append(temp);
        sb.append(c);
    }

}
